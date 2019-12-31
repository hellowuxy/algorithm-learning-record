package cn.wxy.algorithms.insertionsort;

import cn.wxy.utils.ArrayUtils;

/**
 * 插入排序（稳定的排序算法）。
 * 最优时间复杂度：O(n^2)、最差时间复杂服O(1)、平均时间复杂度O(n"2)
 */
public class InsertionSort {

    /**
     * 按照从小到大的顺序排序
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int valueOfIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > value) {
                    // 后移一位
                    array[j + 1] = array[j];
                    valueOfIndex = j;
                }
            }
            array[valueOfIndex] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1};
        sort(array);
        ArrayUtils.printArray(array);

        array = new int[]{1, 9, 7, 3, 5};
        sort(array);
        ArrayUtils.printArray(array);
    }
}
