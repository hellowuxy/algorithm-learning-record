package cn.wxy.algorithms.mergesort;

import cn.wxy.utils.ArrayUtils;

/**
 * 归并排序(稳定的排序算法)。
 * 最优时间复杂度、最差复杂度和平均时间复杂度均为O(n log n)
 *
 * @author hellowuxy
 * @create 2020-01-01
 */
public class MergeSort {

    public static void sort(int[] array) {
        if (array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        // 将tmp中的元素复制到原数组中
        for (int l = 0; l < tmp.length; l++) {
            array[left + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {1};
        sort(array);
        ArrayUtils.printArray(array);

        array = new int[]{3, 2, 1, 4};
        sort(array);
        ArrayUtils.printArray(array);

        array = new int[]{3, 2, 1, 4, 5, 9, 8, 7};
        sort(array);
        ArrayUtils.printArray(array);
    }
}
