package cn.wxy.algorithms.quicksort;

import cn.wxy.utils.ArrayUtils;

/**
 * 快速排序（不稳定排序算法）。
 * 时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 * <tr>
 * <td ALIGN=CENTER>最坏时间复杂度</td>
 * <td ALIGN=CENTER>O(n<sup>2</sup>)</td>
 * </tr>
 * <tr>
 * <td ALIGN=CENTER>最优时间复杂度</td>
 * <td ALIGN=CENTER>O(n log n)</td>
 * </tr>
 * <tr>
 * <td ALIGN=CENTER>平均时间复杂度</td>
 * <td ALIGN=CENTER>O(n log n)</td>
 * </tr>
 * </table>
 *
 * @autor wxyidea
 * @create 2019-06-29
 **/
public class QuickSort {

  public static void sort(int[] array) {
    if (array.length == 0) {
      return;
    }
    sort(array, 0, array.length - 1);
  }

  public static void sort(int[] array, int low, int high) {
    if (low >= high)
      return;
    int p = partition(array, low, high);
    sort(array, low, p - 1);
    sort(array, p + 1, high);
  }

  private static int partition(int[] array, int low, int high) {
    int i = low, j = low;
    int pivot = array[high];
    while (j < high) {
      if (array[j] < pivot) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
      }
      j++;
    }
    array[j] = array[i];
    array[i] = pivot;
    return i;
  }

  public static void main(String[] args) {
    int[] array = {3, 15, 16, 2, 0, 9, 20, 11, 10};
    sort(array);
    ArrayUtils.printArray(array);

    array = new int[]{1};
    sort(array);
    ArrayUtils.printArray(array);

    array = new int[]{1, 2, 3};
    sort(array);
    ArrayUtils.printArray(array);

    array = new int[]{1, 4, 3, 2, 9, 7, 10};
    sort(array);
    ArrayUtils.printArray(array);
  }
}
