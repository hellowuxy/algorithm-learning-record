package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;

/*
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *  假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  示例 1:
 *     输入: [1,2,3]
 *     输出: [1,2,4]
 *     解释: 输入数组表示数字 123。
 *
 *  示例 2:
 *     输入: [4,3,2,1]
 *     输出: [4,3,2,2]
 *     解释: 输入数组表示数字 4321。
 */

/**
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class RemoveDuplicates {

  /**
   * @return 移除重复元素后的数组新长度
   */
  public static int removeDuplicates(int[] arrays) {
    int i = 0, j = 1;
    while (j < arrays.length) {
      if (arrays[i] == arrays[j]) {
        j++;
      } else {
        arrays[++i] = arrays[j++];
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    // test moveDuplicates method
    int arrays[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    ArrayUtils.printArray(arrays, removeDuplicates(arrays));
  }
}
