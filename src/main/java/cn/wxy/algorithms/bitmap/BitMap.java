package cn.wxy.algorithms.bitmap;

/**
 * the implementation of bitmap algorithm
 */
public class BitMap {
    private byte[] array;

    public BitMap(int capacity) {
        array = new byte[capacity / 8 + 1];
    }

    /**
     * @param value value to be stored
     * @return true if store success, else false
     */
    public boolean add(int value) {
        int index = value >> 3;
        if (index >= array.length) {
            return false;
        }
        int position = value & 0x07;
        array[index] |= 1 << position;
        return true;
    }

    /**
     * @param value value to be removed
     * @return true if remove success, else false
     */
    public boolean remove(int value) {
        int index = value >> 3;
        if (index >= array.length) {
            return false;
        }
        int position = value & 0x07;
        array[index] &= ~(1 << position);
        return true;
    }

    /**
     * return true if bitmap contains specified value
     *
     * @param value value whose presence to be tested
     * @return true if bitmap contains specified value, else false
     */
    public boolean contain(int value) {
        int index = value >> 3;
        if (index >= array.length) {
            return false;
        }
        int position = value & 0x07;
        return ((1 << position) & array[index]) != 0;
    }
}
