package cn.wxy.binarysearch;

/**
 * 二分查找算法，思想如下（二分查找只对有序数组有效，假设数组A长度为n，target为查找的目标元素）：
 * <p>（1）令L=0，R=n-1；</p>
 * <p>（2）如果L>R，则搜索以失败而告终；</p>
 * <p>（3）令mid=(L+R)/2（具体实现时，未防止算术溢出，可采用L+(R-L)/2替代）；</p>
 * <p>（4）如果A[mid]<target，令R=mid-1，回到步骤（2）；</p>
 * <p>（5）如果A[mid]>target，令L=mid+1，回到步骤（2）；</p>
 * <p>（6）当A[mid]==target时，搜索结束。</p>
 *
 * 该算法的时间复杂度为 <tt>O(log n)</tt>，空间复杂度为 <tt>O(1)</tt>
 *
 * @autor Wuxiaoyuan
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
    System.out.println(binarySearchCount(2, array));
  }
}
