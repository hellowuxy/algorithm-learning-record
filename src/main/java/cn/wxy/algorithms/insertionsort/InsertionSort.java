package cn.wxy.algorithms.insertionsort;

/**
 * 插入排序（Insertion Sort）是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常
 * 采用in-place排序（即只需用到<i>O(1)</i>的额外空间的排序），因而在从后向前扫描过程
 * 中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 插入排序的运行方式如下（假设按照从小到大的顺序）：
 * <p>(1) 从第一个元素开始，该元素可以被认为已经排序 </p>
 * <p>(2) 取出下一个元素，在已经排序的元素序列中从后往前扫描 </p>
 * <p>(3) 如果该元素（已排序）大于新元素，则将该元素移动到下一位置 </p>
 * <p>(4) 重复步骤(3)直到找到小于或等于新元素的位置</p>
 * <p>(5) 将新元素插入该位置</p>
 * <p>(6) 重复步骤(2)~(5)</p>
 *
 * 插入排序算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>O(n<sup>2</sup>)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(n)</td>
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
 * @create 2019-06-29
 **/
public class InsertionSort {

  /**
   * 以移动元素的方式，使整个数组按从小到大的方式排序
   *
   * @param array 待排序数组
   */
  public static void insertionSortByMove(int[] array) {
    int count = 0; // 统计比较次数
    for (int i = 0; i < array.length - 1; i++) { // 插入排序需要经过N-1轮（N代表数组长度）
      int newEle = array[i + 1]; // 新元素
      int index = i + 1; // 记录新元素的插入位置
      for (int j = i; j >= 0; j--) { // 在已经排序的数组中从后向前扫描
        count++; // 比较次数+1
        if (array[j] > newEle) {
          array[index] = array[j]; // 当前元素大于新元素，向后移动当前元素
          index = j; // 记录新的插入位置
        } else {
          // 已经找到插入位置，终止本轮比较
          break;
        }
      }
      array[index] = newEle; // 插入新元素
    }
    System.out.printf("总共比较了{%d}次%n", count);
  }

  /**
   * 以交换元素的方式，使整个数组按从小到大的方式排序
   *
   * @param array
   */
  public static void insertionSortBySwap(int[] array){
    int count = 0; // 统计比较次数
    for (int i = 0; i < array.length - 1; i++) { // 需要N-1轮排序
      for (int j = i+1; j >0; j--) {
        count++; // 比较次数+1
        if (array[j] < array[j - 1]) {
          // 交换元素
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        } else {
          // 当前部分数组已经有序，终止本轮排序
          break;
        }
      }
    }
    System.out.printf("总共比较了{%d}次%n", count);
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11, 10};
    // sort array
    insertionSortByMove(array);
    // print ordered array
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
  }
}
