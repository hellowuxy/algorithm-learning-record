package cn.wxy.algorithms.binarysearch;

import cn.wxy.utils.AssertUtils;

/**
 * 二分查找的变形问题练习。
 * <p>1. 查找第一个值等于给定值的元素</p>
 * <p>2. 查找最后一个值等于给定值的元素</p>
 * <p>3. 查找第一个值大于等于给定值的元素</p>
 * <p>4. 查找最后一个值小于等于给定值的元素</p>
 *
 * @author hellowuxy
 * @create 2020-01-05
 */
public class BinarySearchPractice {

  /**
   * 查找第一个值等于给定值的元素，返回对应的索引
   *
   * @param target
   * @param array
   * @return
   */
  public static int findFirstEqualElementIndex(int target, int[] array) {
    int low = 0, high = array.length - 1;
    int mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (array[mid] > target) {
        high = mid - 1;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        if (mid == 0 || array[mid - 1] != target) {
          return mid;
        }
        high = mid - 1;
      }
    }
    return -1;
  }

  /**
   * 查找最后一个值等于给定值的元素，返回对应的索引
   *
   * @param target
   * @param array
   * @return
   */
  public static int findLastEqualElementIndex(int target, int[] array) {
    int low = 0, high = array.length - 1;
    int mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (array[mid] > target) {
        high = mid - 1;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        if (mid == array.length - 1 || array[mid + 1] != target) {
          return mid;
        }
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 查找第一个值大于等于给定值的元素，返回对应的索引，返回对应的索引
   *
   * @param target
   * @param array
   * @return
   */
  public static int findFirstGreaterOrEqualExpectedElementIndex(int target, int[] array) {
    int low = 0, high = array.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] >= target) {
        if (mid == 0 || array[mid - 1] < target) {
          return mid;
        }
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 查找最后一个值小于等于给定值的元素
   *
   * @param target
   * @param array
   * @return
   */
  public static int findLastLessOrEqualExpectedElementIndex(int target, int[] array) {
    int low = 0, high = array.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 2);
      if (array[mid] <= target) {
        if (mid == array.length - 1 || array[mid + 1] > target) {
          return mid;
        }
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = {0, 0, 1, 1, 2, 3, 4, 5, 5, 6, 9, 10, 12, 15, 15};
    // index:      0  1  2  3  4  5  6  7  8  9  10 11  12  13  14

    AssertUtils.assertEqual(0, findFirstEqualElementIndex(0, array));
    AssertUtils.assertEqual(1, findLastEqualElementIndex(0, array));

    AssertUtils.assertEqual(2, findFirstEqualElementIndex(1, array));
    AssertUtils.assertEqual(3, findLastEqualElementIndex(1, array));

    AssertUtils.assertEqual(13, findFirstEqualElementIndex(15, array));
    AssertUtils.assertEqual(14, findLastEqualElementIndex(15, array));

    AssertUtils.assertEqual(0, findFirstGreaterOrEqualExpectedElementIndex(0, array));
    AssertUtils.assertEqual(2, findFirstGreaterOrEqualExpectedElementIndex(1, array));
    AssertUtils.assertEqual(7, findFirstGreaterOrEqualExpectedElementIndex(5, array));
    AssertUtils.assertEqual(10, findFirstGreaterOrEqualExpectedElementIndex(7, array));
    AssertUtils.assertEqual(13, findFirstGreaterOrEqualExpectedElementIndex(15, array));

    AssertUtils.assertEqual(1, findLastLessOrEqualExpectedElementIndex(0, array));
    AssertUtils.assertEqual(3, findLastLessOrEqualExpectedElementIndex(1, array));
    AssertUtils.assertEqual(8, findLastLessOrEqualExpectedElementIndex(5, array));
    AssertUtils.assertEqual(11, findLastLessOrEqualExpectedElementIndex(11, array));
    AssertUtils.assertEqual(14, findLastLessOrEqualExpectedElementIndex(15, array));
  }
}
