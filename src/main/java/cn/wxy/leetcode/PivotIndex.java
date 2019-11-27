package cn.wxy.leetcode;

/**
 * 寻找数组的"中心索引"
 *
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class PivotIndex {

  public static int pivotIndex(int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      int leftSum = 0;
      int rightSum = 0;

      // 计算中心索引左侧数之和
      for (int j = 0; j < i; j++) {
        leftSum += arrays[j];
      }
      // 计算中心索引右侧数之和
      for (int k = i + 1; k < arrays.length; k++) {
        rightSum += arrays[k];
      }

      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 该方法是对上面方法的一个优化，提供执行效率
   *
   * @param arrays 数组
   * @return 中心索引下标
   */
  public static int pivotIndexOptimized(int[] arrays) {
    int leftSum = 0;
    int rightSum = 0;
    int sum = 0;
    for (int i = 0; i < arrays.length; i++) {
      sum += arrays[i];
    }

    for (int i = 0; i < arrays.length; i++) {
      // 计算中心索引右侧数之和
      rightSum = sum - leftSum - arrays[i];

      if (rightSum == leftSum) {
        return i;
      }

      // 计算中心索引左侧数之和
      leftSum += arrays[i];
    }
    return -1;
  }
}
