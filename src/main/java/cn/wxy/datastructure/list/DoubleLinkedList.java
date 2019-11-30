package cn.wxy.datastructure.list;

import com.sun.istack.internal.NotNull;

/**
 * double linked list implementation.
 *
 * @author wxyidea
 * @create 2019-11-30
 */
public class DoubleLinkedList<T> {

    /**
     * first node of linked list
     */
    private DLNode<T> first;
    /**
     * last node of linked list
     */
    private DLNode<T> last;

    /**
     * the number of element linked list
     */
    private int size;

    /**
     * add a node to the tail of linked list.
     *
     * @param node the node to be added
     * @return true if successfully add, else false
     */
    public boolean add(@NotNull DLNode<T> node) {
        size++;
        if (first == null) {
            first = last = node;
            return true;
        }
        last.next = node;
        node.prev = last;
        last = node;
        return true;
    }

    /**
     * store value in linked list.
     *
     * @param value the value to be stored
     * @return true if successfully store, else false
     */
    public boolean add(@NotNull T value) {
        if (value == null) {
            throw new IllegalArgumentException("the value must not be null");
        }
        return add(new DLNode<>(value));
    }

    /**
     * return true if linked list contains specific node, else false.
     *
     * @param node the node whose presence to be tested
     * @return true if linked list contains specific node, else false
     */
    public boolean contain(@NotNull DLNode<T> node) {
        if (size == 0) {
            return false;
        }
        DLNode<T> cursor = first;
        while (cursor != null) {
            if (cursor == node) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    /**
     * return true if linked list contains specific value, else false.
     *
     * @param value the value whose presence to be tested
     * @return true if linked list contains specific value, else false
     */
    public boolean contain(T value) {
        if (value == null) {
            throw new IllegalArgumentException("the value can't be null");
        }
        if (size == 0) {
            return false;
        }
        DLNode<T> cursor = first;
        while (cursor != null) {
            if (cursor.value == value) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    /**
     * remove specific node from linked list.
     *
     * @param node the node to be removed
     * @return true if successfully remove, else false
     */
    public boolean remove(@NotNull DLNode<T> node) {
        if (!contain(node)) {
            return false;
        }


        size--;
        if (first == last) {
            first = last = null;
            return true;
        }

        if (node == first) {
            first = first.next;
            first.prev.next = null;
            first.prev = null;
            return true;
        }

        if (node == last) {
            last = last.prev;
            last.next.prev = null;
            last.next = null;
            return true;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        return true;
    }

    /**
     * insert node before specified node.
     *
     * @param specifiedNode specified node
     * @param node          the node to be inserted
     * @return true if successfully insert, else false
     */
    public boolean insertBefore(@NotNull DLNode<T> specifiedNode, @NotNull DLNode<T> node) {
        if (!contain(specifiedNode)) {
            return false;
        }

        // if (size == 1) {
        //     node.next = first;
        //     first.prev = node;
        //     first = node;
        //     return true;
        // }

        size++;

        if (specifiedNode == first) {
            node.next = first;
            first.prev = node;
            first = node;
            return true;
        }

        node.prev = specifiedNode.prev;
        node.next = specifiedNode;
        specifiedNode.prev.next = node;
        specifiedNode.prev = node;
        return true;
    }

    /**
     * insert node after specified node.
     *
     * @param specifiedNode specified node
     * @param node          the node to be inserted
     * @return true if successfully insert, else false
     */
    public boolean insertAfter(@NotNull DLNode<T> specifiedNode, @NotNull DLNode<T> node) {
        if (!contain(specifiedNode)) {
            return false;
        }

        size++;

        if (specifiedNode == last) {
            node.prev = last;
            last.next = node;
            last = node;
            return true;
        }

        node.prev = specifiedNode;
        node.next = specifiedNode.next;
        specifiedNode.next.prev = node;
        specifiedNode.next = node;
        return true;
    }

    /**
     * @return the number of element in linked list
     */
    public int size() {
        return size;
    }

    /**
     * @return the fist node of linked list, null if linked is empty.
     */
    public DLNode<T> first() {
        return first;
    }

    /**
     * @return the last node of linked list, null if linked is empty.
     */
    public DLNode<T> last() {
        return last;
    }

    /**
     * the node of double linked list
     */
    public static class DLNode<T> {
        public DLNode<T> prev;
        public DLNode<T> next;
        public T value;

        public DLNode(T value) {
            this.value = value;
        }
    }
}
