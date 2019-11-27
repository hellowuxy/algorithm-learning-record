package cn.wxy.leetcode;

/**
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
      if (num != 0 && max != num && max / num < 2) {
        return -1;
      }
    }
    return index;
  }
}
