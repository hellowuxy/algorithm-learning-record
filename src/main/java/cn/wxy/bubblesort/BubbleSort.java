package cn.wxy.bubblesort;

/**
 * 冒泡排序（Bubble Sort）是一种简单的排序算法，它重复的走访要排序的数列，每次比较两个元素，
 * 如果他们的顺序错误就交换他们的位置，走访的工作是重复进行直到没有元素需要交换，表明排序已经完成。<br/>
 * 交换元素时，如果小的放前面，最终数列会按照从小到大的顺序；反之，数列将按照从大到小的顺序。<br/>
 *
 * 冒泡排序算法的运作方式如下（假设按从小到大的顺序排序）：
 * <p>（1）比较相邻的两个元素，如果第一个比第二个大，就交换它们；</p>
 * <p>（2）对每一对元素做同样的工作，从开始的第一对到结尾的最后一对，这步完成后，最后一个元素将是最大的元素；</p>
 * <p>（3）针对所有的元素重复以上步骤，除了最后一个；</p>
 * <p>（4）持续每次对越来越少的元素重复以上步骤，直到没有任何一对元素需要比较。</p>
 *
 * 冒泡排序算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>O(n^2)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(n)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>平均时间复杂度</td>
 *     <td ALIGN=CENTER>O(n^2)</td>
 *  </tr>
 * </table>
 *
 * 空间复杂度：<i>O(1)</i>
 *
 *  @autor wxyidea
 * @create 2019-06-28
 **/
public class BubbleSort {

  /**
   * 按照从小到大的顺序排序
   *
   * @param array 待排序数组
   */
  public static void bubbleSort(int[] array) {
    int count = 0; // 统计比较次数

    for (int i = 0; i < array.length - 1; i++) { // 冒泡排序需要经过N-1轮（N代表数组长度）
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) { // 顺序错误，交换相邻元素
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
        count++; // 比较次数+1
      }
    }

    System.out.printf("总共比较了{%d}次\n", count);
  }

  /**
   * 该方法和上面的方法相比，对冒泡排序进行了优化：假如一个有序的数组，长度为N，上面的排序方法中count=N*(N-1)/2，
   * 而该方法中count=N-1
   *
   * @param array 待排序数组
   */
  public static void bubbleSortOptimized(int[] array) {
    int count = 0; // 统计比较次数
    for (int i = 0; i < array.length - 1; i++) { // 最多需要经过N-1轮（N代表数组长度）
      /**
       * 交换标志，本轮比较中发生任意一次交换，即置为true；如果一轮比较结束，swapFlag=false，则说明没有发生元素的交换，
       * 也就是说数组已经有序。所以当发现swapFlag=false时，提前终止比较，从而达到优化冒泡排序算法的目标。
       */
      boolean swapFlag = false;

      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) { // 顺序错误，交换相邻元素
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapFlag = true; // 发生了元素交换，设置标志位为true
        }
        count++; // 比较次数+1
      }

      if(!swapFlag)
        break; // 数组已经有序，提前终止比较
    }
    System.out.printf("总共比较了{%d}次\n", count);
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11, 10};
    // sort array
    bubbleSort(array);
    // print ordered array
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

    // 比较两种冒泡排序算法的效率
    array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    bubbleSort(array);
    bubbleSortOptimized(array);
  }
}
