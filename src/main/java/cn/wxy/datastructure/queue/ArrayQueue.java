package cn.wxy.datastructure.queue;

/**
 * queue array-based
 */
public class ArrayQueue<T> {
    /**
     * default capacity of queue
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * the number of element the queue can hold
     */
    private int capacity;

    /**
     * the number of element in queue
     */
    private int size;

    /**
     * the array used to store element
     */
    private Object[] array;

    /**
     * point next element to be dequeue
     */
    private int headIndex;

    /**
     * point next element to be enqueue
     */
    private int tailIndex;

    /**
     * construct a queue with default capacity 16
     */
    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * construct a queue with specified capacity
     *
     * @param capacity the capacity of queue
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    /**
     * return the number of element in queue
     *
     * @return the number of element in queue
     */
    public int size() {
        return this.size;
    }

    /**
     * add element to the tail of queue
     *
     * @param element the element to be added
     * @return true if enqueue successfully , else false
     */
    public boolean enqueue(T element) {
        if (size == capacity) {
            return false;
        }

        array[tailIndex++] = element;
        if (tailIndex == array.length) {
            tailIndex = 0;
        }
        size++;
        return true;
    }

    /**
     * remove and return the element at head of queue
     *
     * @return removed element, null if queue is empty
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T ele = (T) array[headIndex++];
        if (headIndex == array.length) {
            headIndex = 0;
        }
        size--;
        return ele;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int cur = headIndex;
        for (int i = 0; i < size; i++) {
            sb.append(array[headIndex++]).append(",");
            if (headIndex == array.length) {
                headIndex = 0;
            }
        }

        return sb.substring(0, sb.lastIndexOf(",")) + "]";
    }
}
