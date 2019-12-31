package cn.wxy.algorithms.bubblesort;

import cn.wxy.utils.ArrayUtils;

/**
 * 冒泡排序（稳定的排序算法）。
 * 最优时间复杂度：O(n^2)、最差时间复杂服O(1)、平均时间复杂度O(n"2)。
 */
public class BubbleSort {

    /**
     * 排序数据，从小到大排序
     *
     * @param array 待排序的数据
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 排序数据，从小到大排序。相比上一个排序方法，效率更高一些
     *
     * @param array 待排序的数据
     */
    public static void sortOptimized(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean sorted = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    sorted = true;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1};
        sort(array);
        ArrayUtils.printArray(array);

        array = new int[]{1, 9, 7, 3, 5};
        sort(array);
        ArrayUtils.printArray(array);

        //////////////////////
        array = new int[]{1, 2, 3, 4, 5};
        sortOptimized(array);
        ArrayUtils.printArray(array);

        array = new int[]{10, 2, 9, 4, 5};
        sortOptimized(array);
        ArrayUtils.printArray(array);
    }
}
