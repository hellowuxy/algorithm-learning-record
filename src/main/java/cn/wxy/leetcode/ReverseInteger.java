package cn.wxy.leetcode;

/*
 * 整数反转：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * 示例 1:
 *    输入: 123
 *    输出: 321
 *
 * 示例 2:
 *    输入: -123
 *    输出: -321
 *
 * 示例 3:
 *    输入: 120
 *    输出: 21
 *
 * 注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1],
 *     请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

import org.junit.Assert;

/**
 * @autor wxyidea
 * @create 2019-07-20
 **/
public class ReverseInteger {

  /**
   * 解题思路：从最低为开始，每次反转一个数字，使用Long型变量累加反转后的数值
   */
  public static int reverseInteger(int num) {
    long reverseNum = 0;
    while (num != 0) {
      int digit = num % 10;
      reverseNum = reverseNum * 10 + digit;
      num /= 10;
      // 判断reverseNum是否在[−2^31,  2^31 − 1]之间
      if (reverseNum < Integer.MIN_VALUE || reverseNum > Integer.MAX_VALUE) {
        return 0;
      }
    }
    return (int) reverseNum;
  }

  public static void main(String[] args) {
    Assert.assertEquals(123, reverseInteger(321));
    Assert.assertEquals(0, reverseInteger(Integer.MAX_VALUE));
    Assert.assertEquals(-187, reverseInteger(-781));
    Assert.assertEquals(0, reverseInteger(Integer.MIN_VALUE));
  }
}
