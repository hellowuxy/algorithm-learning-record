package cn.wxy.algorithms.selectionsort;

import cn.wxy.utils.ArrayUtils;

/**
 * 插入排序（不稳定的排序算法）。
 * 最优时间复杂度：O(n^2)、最差时间复杂服O(1)、平均时间复杂度O(n"2)
 **/
public class SelectionSort {

    /**
     * 选择排序法，按照从小到大的顺序排序
     *
     * @param array 待排序的数组
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i]; // 最小的元素
            int index = i; // 最小元素对应的索引
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 4, 8, 9, 7};
        sort(array);
        ArrayUtils.printArray(array);
    }

}
