package cn.wxy.leetcode;

import org.junit.Assert;

/**
 * 在一个给定的数组arrays中，总是存在一个最大元素， 查找数组中的最大元素是否至少是数组中每个其他数字的两倍，
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 *   示例 1:
 *      输入: arrays = [3, 6, 1, 0]
 *      输出: 1
 *      解释: 6是最大的整数, 对于数组中的其他整数, 6大于数组中其他元素的两倍。6的索引是1, 所以返回1.
 *
 *    示例 2:
 *       输入: arrays = [1, 2, 3, 4]
 *       输出: -1
 *       解释: 4没有超过3的两倍大, 所以返回 -1.
 *
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class DominantIndex {
  public static int dominantIndex(int[] arrays) {
    int max = arrays[0];
    int index = 0;

    // 找出最大数
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i] > max) {
        max = arrays[i];
        index = i;
      }
    }

    for (int num : arrays) {
      // 判断最大值是否是其它数字的最少2倍，注意：过滤自身和0
      if (num != 0 && max != num && max / num < 2)
        return -1;
    }
    return index;
  }

  public static void main(String[] args) {
    // 测试dominantIndex方法
    int[] arrays3 = {0, 0, 0, 1};
    Assert.assertEquals(3, dominantIndex(arrays3));
    int[] arrays4 = {3, 6, 1, 0};
    Assert.assertEquals(1, dominantIndex(arrays4));
    int[] arrays5 = {1, 2, 3, 4};
    Assert.assertEquals(-1, dominantIndex(arrays5));
  }
}
