package cn.wxy.algorithms.lru;

/**
 * LinkedList-based LRU cache implementation, the element least recently used stores at the head of linked list,
 * and the element frequently recently used stores at the tail of linked list.
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
     * the first node of linked list
     */
    private Node<T> first;

    /**
     * the last node of linked list
     */
    private Node<T> last;

    /**
     * construct LRU cache with specific capacity, and when the cache is full, no element evicted
     *
     * @param capacity the capacity of cache
     */
    public LRUBasedLinkedList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * add specific element to cache, when the cache is full, evicting element recently less frequently used.
     *
     * @param element the element to be added
     * @return if cache is full,return the element evicted, else return <code>null</code>
     */
    public T add(T element) {
        /*
         1. checking whether element exists or not in cache, if exists, remove element and then put it on head of linked list,
         2. if not exist, check capacity of cache, evicting element recently less frequently used when cache is full,
         3. add element to cache.
        */

        Node<T> node = contains(element);
        if (node != null) {
            if (size == 1) {
                // only have a element in cache, do nothing.
                return null;
            }

            if (node == first) {
                // the element had at the head of linked list, do nothing
                return null;
            }

            // remove element
            if (node == last) {
                last = node.prev;
                last.next = null;
                node.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }

            // put it on head of linked list
            first.prev = node;
            node.next = first;
            first = node;
            return null;
        }

        Node<T> evicted = null;
        if (size >= capacity) {
            evicted = last;
            // remove last element
            Node<T> prev = last.prev;
            prev.next = null;
            last.prev = null;
            last = prev;
            size--;
        }

        // add element to the head of linked list
        if (size == 0) {
            first = last = new Node<>(element);
        } else {
            Node<T> n = new Node<>(element);
            first.prev = n;
            n.next = first;
            first = n;
        }
        size++;
        return evicted == null ? null : evicted.element;
    }

    /**
     * retrieve node that contains specific element
     *
     * @param element the element whose presence to be tested
     * @return the node that contains specific element, return null if no node of linked list contain specific element
     */
    private Node<T> contains(T element) {
        Node<T> cursor = first;
        while (cursor != null) {
            if (cursor.element == element) {
                return cursor;
            }
            cursor = cursor.next;
        }
        return null;
    }

    /**
     * remove element recently less frequently used
     *
     * @return the element removed
     */
    public T remove() {
        Node<T> removed = last;

        // remove last node
        Node<T> node = last.prev;
        node.next = null;
        last.prev = null;
        last = node;

        size--;

        return removed.element;
    }

    /**
     * get element frequently recently used
     *
     * @return frequently recently used element, return null if cache is empty
     */
    public T getLatest() {
        if (size == 0) {
            return null;
        }
        return first.element;
    }

    /**
     * get element least recently used
     *
     * @return the element least recently used, return null if cache is empty
     */
    public T getEarliest() {
        if (size == 0) {
            return null;
        }
        return last.element;
    }

    static class Node<T> {
        public Node<T> prev;
        public Node<T> next;
        public T element;

        public Node(T element) {
            this.element = element;
        }
    }
}
