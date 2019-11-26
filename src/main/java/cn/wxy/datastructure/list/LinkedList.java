package cn.wxy.datastructure.list;

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
     * the head node of linkedList that is first node if linkedList not null
     */
    private Node<T> head;

    public LinkedList() {
        this.size = 0;
    }

    /**
     * construct linkedList with specific head node
     *
     * @param head head node(first node)
     */
    public LinkedList(Node<T> head) {
        this.head = head;
        this.size = 1;
    }

    /**
     * @return return head node of linkedList, null if linkedList is null
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
     * @param node added node
     */
    public void add(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("node must not be null");
        }

        if (head == null) {
            head = node;
        } else {
            Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

        size++;
    }

    /**
     * add a new node with specified value to the tail linkedList
     *
     * @param val added value
     */
    public void add(T val) {
        add(new Node<T>(val));
    }

    /**
     * remove a node from linkedList
     *
     * @param node the node to be removed
     * @return true if node exists and removed, else false
     */
    public boolean remove(Node<T> node) {
        if (node == null)
            throw new IllegalArgumentException("node must not be null");

        if (size() < 1)
            return false;

        if (head == node) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> n = head;
        // look node to be removed
        while (n != null && n.next != node) {
            n = n.next;
        }
        if (n != null) {
            // find it , so remove it!
            n.next = n.next.next;
        }

        size--;
        return true;
    }

    /**
     * remove node that saves specified value
     *
     * @param val specified value
     * @return true if node exists and removed, else false
     */
    public boolean remove(T val) {
        if (size() < 1) {
            return false;
        }

        if (head.val == val) {
            return remove(head);
        }

        Node<T> n = head;
        while (n != null) {
            if (n.next != null && n.val == val) {
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
    public boolean contain(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("node must not be null");
        }

        if (size() < 1) {
            return false;
        }

        Node<T> n = head;
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
    public boolean contain(T val) {
        if (size() < 1) {
            return false;
        }

        Node<T> n = head;
        while (n != null) {
            if (n.val == val) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    /**
     * insert newNode before specified node 'n'
     *
     * @param specifiedNode
     * @param newNode new node to be inserted
     * @return true if success to insert new node, else false
     */
    public boolean insertBefore(Node<T> specifiedNode, Node<T> newNode) {
        if (specifiedNode == null) {
            throw new IllegalArgumentException("node must not be null");
        }
        if (newNode == null) {
            throw new IllegalArgumentException("node must not be null");
        }

        if (size() < 1) {
            return false;
        }

        if (head == specifiedNode) {
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }

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
     * insert newNode after specified node 'n'
     *
     * @param specifiedNode
     * @param newNode new node to be inserted
     * @return true if success to insert new node, else false
     */
    public boolean insertAfter(Node<T> specifiedNode, Node<T> newNode){
        if (specifiedNode == null) {
            throw new IllegalArgumentException("node must not be null");
        }
        if (newNode == null) {
            throw new IllegalArgumentException("node must not be null");
        }

        if (size() < 1) {
            return false;
        }

        Node<T> n = head;
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
