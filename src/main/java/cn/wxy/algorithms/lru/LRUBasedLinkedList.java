package cn.wxy.algorithms.lru;

import cn.wxy.datastructure.list.DoubleLinkedList;

/**
 * LRU implementation based linked list
 *
 * @author wxyidea
 * @create 2019-12-03
 */
public class LRUBasedLinkedList<T> {
    /**
     * the capacity of cache
     */
    private int capacity;

    /**
     * the number of element of cache
     */
    private int size = 0;

    /**
     * whether evicting element or not when cache is full
     */
    private boolean eviction = false;

    private DoubleLinkedList<T> linkedList;

    /**
     * construct LRU cache with specific capacity, and when the cache is full, no element evicted
     *
     * @param capacity the capacity of cache
     */
    public LRUBasedLinkedList(int capacity) {
        this(capacity, false);
    }

    /**
     * construct LRU cache with specific capacity and eviction strategy
     *
     * @param capacity the capacity of cache
     * @param eviction true for evicting element when cache if full,false for not
     */
    public LRUBasedLinkedList(int capacity, boolean eviction) {
        this.capacity = capacity;
        this.eviction = eviction;
        linkedList = new DoubleLinkedList<>();
    }

    /**
     * add specific element to cache, when the cache is full, evicting element recently less frequently used if
     * <code>eviction</code> is true, else throw {@link RuntimeException}
     *
     * @param element the element to be added
     */
    public void add(T element) {
        /*
         1. check capacity of cache
         2. checking whether element exists or not in cache
         3. add element if not exist, else remove element and then put it on head of linked list
        */

        if (size >= capacity && !eviction) {
            throw new RuntimeException("the cache is null, and element can't be evicted");
        } else if (size >= capacity && eviction) {
            // remove element recently less frequently used
            linkedList.remove(linkedList.last());
            size--;
        }

        if (linkedList.contain(element)) {
            linkedList.remove(element);
            linkedList.insertBefore(linkedList.first(), new DoubleLinkedList.DLNode<>(element));
            return;
        }

        // add element to the head of linked list
        if (size == 0) {
            linkedList.add(element);
        } else {
            linkedList.insertBefore(linkedList.first(), new DoubleLinkedList.DLNode<>(element));
        }
        size++;
    }

    /**
     * remove element recently less frequently used
     *
     * @return the element removed
     */
    public T remove() {
        DoubleLinkedList.DLNode<T> node = linkedList.last();
        linkedList.remove(linkedList.last());
        size--;
        return node.value;
    }

    /**
     * get element most recently visited
     *
     * @return most recently visited element
     */
    public T getLatestElement() {
        return linkedList.first().value;
    }

    /**
     * get element recently less frequently used
     *
     * @return the element recently less frequently used
     */
    public T getEarliestElement() {
        return linkedList.last().value;
    }
}
