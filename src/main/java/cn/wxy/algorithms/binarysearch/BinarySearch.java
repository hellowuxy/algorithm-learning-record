package cn.wxy.algorithms.binarysearch;

/**
 * 二分查找（binary search）
 * <p>
 * 二分查找算法的时间复杂度如下所示：
 * <table BORDER CELLPADDING=5 CELLSPACING=1>
 * <tr>
 * <td ALIGN=CENTER>最坏时间复杂度</td>
 * <td ALIGN=CENTER>O(log n)</td>
 * </tr>
 * <tr>
 * <td ALIGN=CENTER>最优时间复杂度</td>
 * <td ALIGN=CENTER>O(1)</td>
 * </tr>
 * <tr>
 * <td ALIGN=CENTER>平均时间复杂度</td>
 * <td ALIGN=CENTER>O(log n)</td>
 * </tr>
 * </table>
 *
 * @autor hellowuxy
 * @create 2019-06-28
 **/
public class BinarySearch {

  /**
   * 二分查找
   */
  public static int binarySearch(int target, int[] array) {
    int low = 0, high = array.length - 1;
    int mid = low + (high - low) / 2;
    while (low <= high) {
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
      mid = low + (high - low) / 2;
    }
    return -1;
  }

  /**
   * 二分查找的递归实现
   */
  public static int binarySearchRecursive(int target, int[] array) {

    return binarySearchInternally(0, array.length - 1, target, array);
  }

  private static int binarySearchInternally(int low, int high, int target, int[] array) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > target) {
      return binarySearchInternally(low, mid - 1, target, array);
    } else {
      return binarySearchInternally(mid + 1, high, target, array);
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("目标元素下标：" + binarySearch(2, array));
    System.out.println("目标元素下标：" + binarySearchRecursive(3, array));
  }
}
