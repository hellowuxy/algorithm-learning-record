package cn.wxy.quartsort;

/**
 * 快速排序算法:它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部
 * 分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序采用分治思想，步骤如下：
 * <p>
 *   （1）挑选基准值：从数列中挑选一个元素，称为“基准”(pivot)
 * </p>
 * <p>
 *   （2）分割：重新排序序列，所有比基本值小的放在基准值前边，
 *  所有比基准值大的放在基准值右边（与基准值相等的可以放在任意一边），
 *  此次分割结束后，对基准值的排序已经完成
 * </p>
 * <p>
 *   （3）递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列进行排序
 * </p><br/>
 *
 * 快速排序算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>O(n^2)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(n long n)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>平均时间复杂度</td>
 *     <td ALIGN=CENTER>O(n long n)</td>
 *  </tr>
 * </table>
 *
 * @autor wxyidea
 * @create 2019-06-29
 **/
public class QuartSort {

  /**
   * 采用原地分割的快速排序
   *
   * @param array 待排序数组
   * @param low 分割后的子数组部分的低位下标
   * @param high 分割后的子数组部分的高位下标
   */
  public static void quick_sort(int[] array, int low, int high) {
    if (low >= high)
      return;

    int i = low, j = high;
    // 选取基准值
    int key = array[low];

    while (i != j) {
      // 从j开始向前搜索，找到第一个小于key的值
      while (i < j && array[j] >= key)
        j--;
      if (i < j)
        array[i] = array[j]; // 小于key的元素放在左边

      // 从i开始向后搜索，找到第一个大于key的值
      while (i < j && array[i] <= key)
        i++;
      if (i < j)
        array[j] = array[i]; // 大于key的元素放在右边
    }
    // 插入key
    array[i] = key;

    // 排序小于的key的子数组
    quick_sort(array, low, i - 1);
    // 排序大于key的子数组
    quick_sort(array, i + 1, high);
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11, 10};
    // sort array
    quick_sort(array, 0, array.length - 1);
    // print ordered array
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
  }
}
