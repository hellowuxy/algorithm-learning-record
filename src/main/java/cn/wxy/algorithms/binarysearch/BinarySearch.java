package cn.wxy.algorithms.binarysearch;

/**
 * 二分查找（binary search），又叫折半查找（half-interval search）、对数查找（logarithmic search），它是一种在有序数组中
 * 查找某一特定元素的搜索算法。搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果该特定元素大于中间元素，则在数组中大于中间元素的那一半中查找；如果该特定元素小于中间元素，则在数组中小于中间元素的那一半中查找；
 * 如果在某一部中数组为空，则代表找不到。这种搜索算法每次都使搜索范围减少一半。
 *
 * 二分查找算法的运作方式如下（二分查找只对有序数组有效，假设数组A长度为n，target为查找的目标元素）：
 * <p>（1）令L=0，R=n-1；</p>
 * <p>（2）如果L>R，则搜索以失败而告终；</p>
 * <p>（3）令mid=(L+R)/2（具体实现时，未防止算术溢出，可采用L+(R-L)/2替代）；</p>
 * <p>（4）如果A[mid]<target，令R=mid-1，回到步骤（2）；</p>
 * <p>（5）如果A[mid]>target，令L=mid+1，回到步骤（2）；</p>
 * <p>（6）当A[mid]==target时，搜索结束。</p>
 *
 * 二分查找算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 *  <tr>
 *     <td ALIGN=CENTER>最坏时间复杂度</td>
 *     <td ALIGN=CENTER>O(log n)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>最优时间复杂度</td>
 *     <td ALIGN=CENTER>O(1)</td>
 *  </tr>
 *  <tr>
 *     <td ALIGN=CENTER>平均时间复杂度</td>
 *     <td ALIGN=CENTER>O(log n)</td>
 *  </tr>
 * </table>

 *
 * @autor wxyidea
 * @create 2019-06-28
 **/
public class BinarySearch {

  /**
   * 二分查找目标元素需要的次数
   *
   * @param target 目标元素
   * @return 查找次数，若未查找到目标元素，则返回0；
   */
  public static int binarySearchCount(int target, int[] array) {
    int start = 0, end = array.length - 1;
    int mid = start + (end - start) / 2;// 避免数据溢出
    int count = 0;
    while (start < end) {
      count++;
      if (target == array[mid])
        return count;
      else if (target > array[mid])
        start = mid + 1;
      else
        end = mid - 1;
      mid = start + (end - start) / 2;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("找到目标元素所用次数："+binarySearchCount(2, array));
  }
}
