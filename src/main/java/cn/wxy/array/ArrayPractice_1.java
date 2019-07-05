package cn.wxy.array;

import cn.wxy.utils.ArrayUtils;
import org.junit.Assert;

import java.math.BigInteger;

/**
 * 关于数组的一些练习1
 *
 * @autor wxyidea
 * @create 2019-07-01
 **/
public class ArrayPractice_1 {


  /////////////////////////////////////////////////////////////////////////////////////////////
  //
  // Question 1：寻找数组的"中心索引"，"中心索引":数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和，
  //             如果数组不存在中心索引，返回 -1。如果数组有多个中心索引，返回最靠近左边的那一个
  // 示例1：
  //    输入: arrays = [1,7,3,6,5,6]
  //    输出: 3
  //    解释: 索引3 (arrays[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等
  //
  // 示例2：
  //    输入: arrays = [1,2,3]
  //    输出: -1
  //    解释: 数组中不存在满足此条件的中心索引
  //
  // 示例3：
  //    输入: arrays = [-1,-1,-1,0,1,1]
  //    输出: 0
  //    解释: 索引0 (arrays[0] = -1) 的左侧数之和(0)，与右侧数之和((-1) + (-1) + 0 + 1 + 1 = 11)相等。
  //
  /////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * @param arrays 数组
   * @return 中心索引下标
   */
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

  //////////////////////////////////////////////////////////////
  // Question 2: 在一个给定的数组arrays中，总是存在一个最大元素，
  //             查找数组中的最大元素是否至少是数组中每个其他数字的两倍，
  //             如果是，则返回最大元素的索引，否则返回-1。
  //
  // 示例 1:
  //    输入: arrays = [3, 6, 1, 0]
  //    输出: 1
  //    解释: 6是最大的整数, 对于数组中的其他整数, 6大于数组中其他元素的两倍。6的索引是1, 所以返回1.
  //
  // 示例 2:
  //    输入: arrays = [1, 2, 3, 4]
  //    输出: -1
  //    解释: 4没有超过3的两倍大, 所以返回 -1.
  //
  //
  //////////////////////////////////////////////////////////////

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


  /*
      给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
      最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
      假设除了整数 0 之外，这个整数不会以零开头。

      示例 1:
        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。

      示例 2:
        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。
   */

  /**
   * 第一种解法
   *
   * @param arrays 整型数组
   * @return 加1后的数组
   */
  public static int[] plusOne_way1(int[] arrays) {
    // 当最低小于9时，令最低位加1后，直接返回即可
    if (arrays[arrays.length - 1] < 9) {
      arrays[arrays.length - 1]++;
      return arrays;
    }

    // 当arrays[i]=9,其中0<i<arrays.length-1，低位+1后数组长度也要+1
    int[] copy = new int[arrays.length + 1];
    copy[0] = 1;
    boolean flag = true;
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i] < 9)
        flag = false;
    }
    if (flag) return copy;

    //arrays[arrays.length-1]=9的情况
    for (int i = arrays.length - 1; i > 0; i--) {
      if (arrays[i] == 9) {
        arrays[i] = 0;
        arrays[i - 1]++;
      } else {
        arrays[i]++;
      }
      if (arrays[i - 1] > 9) {
        arrays[i - 1] = 9;
      }
    }
    return arrays;
  }

  /**
   * 第二种解法
   *
   * @param arrays 整型数组
   * @return +1后的数组
   */
  public static int[] plusOne_way2(int[] arrays) {
    for (int i = arrays.length - 1; i >= 0; i--) {
      arrays[i]++;
      arrays[i] %= 10;
      // 如果arrays[i]=0,说明需要执行进位操作，否则直接返回
      if (arrays[i] != 0)
        return arrays;
    }
    // 最高位发生了进位，数组长度+1
    arrays = new int[arrays.length + 1];
    arrays[0] = 1;
    return arrays;
  }


  /**
   * 第3种解法
   *
   * @param arrays 整型数组
   * @return +1后的数组
   */
  public static int[] plusOne_way3(int[] arrays) {
    StringBuilder sb = new StringBuilder();
    for (int num : arrays)
      sb.append(num);

    BigInteger digitsDecimal = new BigInteger(sb.toString());
    digitsDecimal = digitsDecimal.add(new BigInteger("1"));

    char[] chars = digitsDecimal.toString().toCharArray();
    arrays = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      arrays[i] = chars[i] - 48;
    }
    return arrays;
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


    // 测试dominantIndex方法
    int[] arrays3 = {0, 0, 0, 1};
    Assert.assertEquals(3, dominantIndex(arrays3));
    int[] arrays4 = {3, 6, 1, 0};
    Assert.assertEquals(1, dominantIndex(arrays4));
    int[] arrays5 = {1, 2, 3, 4};
    Assert.assertEquals(-1, dominantIndex(arrays5));

    // 测试plusOne方法
    int[] array6 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    // int[] array6 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 1};
    // int[] array6 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    ArrayUtils.printArray(array6);
    array6 = plusOne_way3(array6);
    ArrayUtils.printArray(array6);
  }
}
