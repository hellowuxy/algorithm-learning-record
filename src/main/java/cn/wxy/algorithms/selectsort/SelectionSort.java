package cn.wxy.algorithms.selectsort;

/**
 * 选择排序（selection sort）是一种简单直观的排序算法。它的工作原理如下：首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 选择排序算法的运作方式如下（假设按照从小到大的顺序排序）：
 * <p>（1）找到数组中最小的元素，和数组中第一个位置的元素交换；</p>
 * <p>（2）从剩余元素中找到最小的元素，和数组中第二个位置的元素交换；</p>
 * <p>（3）如此重复，直到整个数组有序（从小到大）。</p>
 *
 * 二分查找算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>O(n<sup>2</sup>)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(n<sup>2</sup>)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>平均时间复杂度</td>
 *     <td ALIGN=CENTER>O(n<sup>2</sup>)</td>
 *  </tr>
 * </table>
 *
 * 空间复杂度：<i>O(1)</i>
 *
 * @autor wxyidea
 * @create 2019-06-28
 **/
public class SelectionSort {

  /**
   * 使用选择排序法，将数组<tt>array</tt>按照从小到大的顺序排序
   *
   * @param array 待排序的数组
   */
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // 本轮比较中最小的元素
      int min = array[i];
      // 本轮比较中最小的元素对应的下标
      int minIndex = i;

      for (int j = i + 1; j < array.length; j++) {
        if (min > array[j]) {
          min = array[j];
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = min;
      array[minIndex] = temp;
    }
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11, 10};
    // sort array
    selectionSort(array);
    // print ordered array
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

  }

}
