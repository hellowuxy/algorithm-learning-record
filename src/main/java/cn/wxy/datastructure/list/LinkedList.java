package cn.wxy.datastructure.list;

import com.sun.istack.internal.NotNull;

/**
 * implementation of linkedList
 *
 * @author wxyidea
 * @create 2019-11-26
 */
public class LinkedList<T> {

    /**
     * the number of element in linkedList
     */
    private int size;
    /**
     * sentinel node, used to simplify code logic
     */
    private Node<T> head = new Node<>(null);

    /**
     * @return head node of linkedList
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * @return return the number of element in linkedList
     */
    public int size() {
        return this.size;
    }

    /**
     * add a new node to the tail of linkedList
     *
     * @param node node to be added
     */
    public void add(@NotNull Node<T> node) {
        Node<T> n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        size++;
    }

    /**
     * add a new node with specified value to the tail linkedList
     *
     * @param val added value
     */
    public void add(@NotNull T val) {
        add(new Node<T>(val));
    }

    /**
     * remove a node from linkedList
     *
     * @param node the node to be removed
     * @return true if node exists and removed, else false
     */
    public boolean remove(@NotNull Node<T> node) {
        Node<T> n = head;
        while (n.next != null) {
            if (n.next == node) {
                n.next = n.next.next;
                size--;
                return true;
            }
            n = n.next;
        }
        return false;
    }

    /**
     * remove node that saves specified value
     *
     * @param val specified value
     * @return true if node exists and removed, else false
     */
    public boolean remove(@NotNull T val) {
        Node<T> n = head;
        while (n.next != null) {
            if (n.next.val == val) {
                n.next = n.next.next;
                size--;
                return true;
            }
            n = n.next;
        }

        return false;
    }

    /**
     * return true if linkedList contains specified node, else false
     *
     * @param node node whose presence in linkedList list is to be tested
     * @return true if linkedList contains specified node, else false
     */
    public boolean contain(@NotNull Node<T> node) {
        // if (size() < 1) {
        //     return false;
        // }

        Node<T> n = head.next;
        while (n != null) {
            if (n == node) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    /**
     * return true if existing node in linkedList contains specified value, else false
     *
     * @param val value whose presence in linkedList to be tested
     * @return true if existing node in linkedList contains specified value, else false
     */
    public boolean contain(@NotNull T val) {
        // if (size() < 1) {
        //     return false;
        // }

        Node<T> n = head.next;
        while (n != null) {
            if (n.val == val) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    /**
     * insert newNode before specified node
     *
     * @param specifiedNode
     * @param newNode       new node to be inserted
     * @return true if success to insert new node, else false
     */
    public boolean insertBefore(@NotNull Node<T> specifiedNode, @NotNull Node<T> newNode) {
        Node<T> n = head;
        while (n != null) {
            if (n.next == specifiedNode) {
                newNode.next = n.next;
                n.next = newNode;
                size++;
                return true;
            }
            n = n.next;
        }

        return false;
    }

    /**
     * insert newNode after specified node
     *
     * @param specifiedNode
     * @param newNode       new node to be inserted
     * @return true if success to insert new node, else false
     */
    public boolean insertAfter(Node<T> specifiedNode, Node<T> newNode) {
        Node<T> n = head.next;
        while (n != null) {
            if (n == specifiedNode) {
                newNode.next = n.next;
                n.next = newNode;
                size++;
                return true;
            }
            n = n.next;
        }

        return false;
    }

    public static class Node<T> {
        /**
         * the value saved in node
         */
        public T val;

        /**
         * the pointer to next node
         */
        public Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }
}
