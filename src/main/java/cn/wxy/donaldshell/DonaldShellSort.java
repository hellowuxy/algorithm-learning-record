package cn.wxy.donaldshell;

/**
 * 希尔排序的核心思想:
 *  将待排序列划分为若干组,在每一组内进行插入排序,让元
 *  素可以一次性的朝最终位置前进一大步,以使整个序列基本
 *  有序,然后再对整个序列进行插入排序。算法的最后一步就是
 *  普通的插入排序,但是这个时候,需要排序的数据几乎是已
 *  经排好的了,所以会非常高效。
 *
 * 希尔排序算法的时间复杂度如下所示：2power2
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>已知最好的：O(n log ^2 n)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(n)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>平均时间复杂度</td>
 *     <td ALIGN=CENTER>根据步长序列的不同而不通</td>
 *  </tr>
 * </table>
 *
 * 空间复杂度：<i>O(1)</i>
 *
 * @autor wxyidea
 * @create 2019-06-29
 **/
public class DonaldShellSort {

  /**
   * 按照从小到大的顺序排序
   *
   * @param array 待排序数组
   */
  public static void shellSort(int[] array) {
    /**
     * 希尔排序步长，初始步长设置为数组长度的一半；
     * 注意：希尔排序的步长选择非常关键，排序效率、时间复杂度的好坏都和步长相关。
     */
    int stepSize = array.length / 2;
    while (stepSize > 0) {
      for (int i = stepSize; i < array.length; i++) {
        // 通过stepSize将array划分为若干组，组内使用插入排序
        int j = i;
        while ((j - stepSize >= 0) && array[j] < array[j - stepSize]) {
          // 交换元素
          int temp = array[j];
          array[j] = array[j - stepSize];
          array[j - stepSize] = temp;

          // 继续向前扫描
          j -= stepSize;
        }
      }
      //设置下一轮排序的stepSize
      stepSize /= 2;
    }
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11, 10};
    // sort array
    shellSort(array);
    // print ordered array
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
  }
}
