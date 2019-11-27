package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;

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
