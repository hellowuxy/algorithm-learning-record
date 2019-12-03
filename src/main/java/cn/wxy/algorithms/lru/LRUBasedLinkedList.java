package cn.wxy.algorithms.lru;

/**
 * LinkedList-based LRU cache implementation
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
            Node<T> prev = last.prev;
            prev.next = null;
            last.prev = null;
            last = prev;
            size--;
        }

        Node<T> node = contains(element);
        if (node != null) {
            // remove element
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;

            // put it on head of linked list
            first.prev=node;
            node.next = first;
            first = node;
            return;
        }

        // add element to the head of linked list
        if (size == 0) {
            first = last = new Node<>(element);
        } else {
            Node<T> n = new Node<>(element);
            first.prev=n;
            n.next = first;
            first = n;
        }
        size++;
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
        node.next =null;
        last.prev = null;
        last = node;

        size--;

        return removed.element;
    }

    /**
     * get element most recently visited
     *
     * @return most recently visited element
     */
    public T getLatestElement() {
        return first.element;
    }

    /**
     * get element recently less frequently used
     *
     * @return the element recently less frequently used
     */
    public T getEarliestElement() {
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
