package cn.wxy.datastructure.stack;

/**
 * stack array-based
 */
public class ArrayStack<T> {

    /**
     * default capacity of stack
     */
    private final int DEFAULT_CAPACITY = 16;

    /**
     * the number of element the stack can hold
     */
    private int capacity;

    /**
     * the number of element in stack
     */
    private int size;

    /**
     * the array used to store element
     */
    private Object[] array;

    /**
     * construct a stack with default capacity 16
     */
    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * construct a stack with specified capacity
     *
     * @param capacity specified capacity of stack
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    /**
     * return the number of element in stack
     *
     * @return the number of element in stack
     */
    public int size() {
        return this.size;
    }

    /**
     * push a element to stack
     *
     * @param element
     * @return true if push successfully, else false
     */
    public boolean push(T element) {
        if (size == capacity) {
            return false;
        }
        array[size++] = element;
        return true;
    }

    /**
     * Pop the top element of the stack
     *
     * @return the top element of stack, null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            return null;
        }
        return (T) array[--size];
    }
}
