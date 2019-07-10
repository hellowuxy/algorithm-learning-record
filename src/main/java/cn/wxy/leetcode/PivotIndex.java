package cn.wxy.leetcode;

import org.junit.Assert;

/**
 * 寻找数组的"中心索引"，"中心索引":数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和，
 *              如果数组不存在中心索引，返回 -1。如果数组有多个中心索引，返回最靠近左边的那一个
 *    示例1：
 *       输入: arrays = [1,7,3,6,5,6]
 *       输出: 3
 *       解释: 索引3 (arrays[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等
 *
 *    示例2：
 *       输入: arrays = [1,2,3]
 *       输出: -1
 *       解释: 数组中不存在满足此条件的中心索引
 *
 *    示例3：
 *       输入: arrays = [-1,-1,-1,0,1,1]
 *       输出: 0
 *       解释: 索引0 (arrays[0] = -1) 的左侧数之和(0)，与右侧数之和((-1) + (-1) + 0 + 1 + 1 = 11)相等。
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
      for (int j = 0; j < i; j++)
        leftSum += arrays[j];
      // 计算中心索引右侧数之和
      for (int k = i + 1; k < arrays.length; k++)
        rightSum += arrays[k];

      if (leftSum == rightSum)
        return i;
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

  public static void main(String[] args) {
    // 测试pivotIndex和pivotIndexOptimized
    int[] array1 = {1, 7, 3, 6, 5, 6};
    Assert.assertEquals(3, pivotIndex(array1));
    Assert.assertEquals(3, pivotIndexOptimized(array1));


    // 比较pivotIndex和pivotIndexOptimized的执行效率
    int[] array2 = new int[100000];
    for (int i = 0; i < 100000; i++) {
      array2[i] = i;
    }
    long s1 = System.currentTimeMillis();
    pivotIndex(array2);
    long s2 = System.currentTimeMillis();
    System.out.printf("优化前，查找中间索引耗时{%d}ms\n", (s2 - s1));

    s1 = System.currentTimeMillis();
    pivotIndexOptimized(array2);
    s2 = System.currentTimeMillis();
    System.out.printf("优化后，查找中间索引耗时{%d}ms\n", (s2 - s1));
  }
}
