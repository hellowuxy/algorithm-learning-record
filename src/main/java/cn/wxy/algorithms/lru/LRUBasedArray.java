package cn.wxy.algorithms.lru;

/**
 * lru cache implementation array-based, the element used recently stores at position that index 'size-1' of array,
 * the element least recently used stores at  position that 'index 0' of array.
 *
 * @author wxyidea
 * @create 2019-12-08
 */
public class LRUBasedArray<T> {
    /**
     * the capacity of lru cache
     */
    private int capacity;

    /**
     * the number of element of lru cache
     */
    private int size = 0;

    /**
     * the index that stores next element
     */
    private int nextIndex = 0;

    /**
     * the array used to store element
     */
    private Object[] cache;

    /**
     * construct lru cache with specific capacity
     *
     * @param capacity
     */
    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        cache = new Object[capacity];
    }

    /**
     * add element to cache
     *
     * @param e the element to be stored
     * @return if cache is full,return the element evicted, else return <code>null</code>
     */
    @SuppressWarnings("unchecked")
    public T add(T e) {
        /*
         1. checking whether element exists or not in cache, if exists, remove element and then put it on tail of array,
         2. if not exist, check capacity of cache, evicting element recently less frequently used when cache is full,
         3. add element to cache.
        */
        int index = contains(e);
        if (index >= 0) {
            if (size == 1) {
                // only have a element in cache, do nothing.
                return null;
            }
            if (index == size - 1) {
                // the element had at the tail of array, do nothing
                return null;
            }

            // rebuild array, put element on the tail of array
            Object[] newCache = new Object[capacity];
            for (int i = 0; i < size - 1; i++) {
                if (i < index) {
                    newCache[i] = cache[i];
                } else {
                    // elements after 'index' step forward a position
                    newCache[i] = cache[i + 1];
                }
            }
            cache = newCache;
            // adjust nextIndex
            nextIndex--;
            cache[nextIndex++] = e;
            return null;
        }

        T evicted = null;
        if (size >= capacity) {
            evicted = (T) cache[0];

            // rebuild array,and evicting first element
            Object[] newCache = new Object[capacity];
            for (int i = 0; i < size - 1; i++) {
                newCache[i] = cache[i + 1];
            }
            cache = newCache;
            // adjust nextIndex
            nextIndex--;
            size--;
        }
        cache[nextIndex++] = e;
        size++;
        return evicted;
    }

    private int contains(T e) {
        for (int i = 0; i < size; i++) {
            if (cache[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * get element most recently visited. <br/>
     * NOTE: if cache is empty, return <code>null</code>
     *
     * @return most recently visited element
     */
    @SuppressWarnings("unchecked")
    public T getLatest() {
        if (size == 0) {
            return null;
        }
        return (T) cache[nextIndex - 1];
    }

    /**
     * get element recently less frequently used <br/>
     * NOTE: if cache is empty, return <code>null</code>
     *
     * @return the element recently less frequently used
     */
    @SuppressWarnings("unchecked")
    public T getEarliest() {
        if (size == 0) {
            return null;
        }
        return (T) cache[0];
    }


}
