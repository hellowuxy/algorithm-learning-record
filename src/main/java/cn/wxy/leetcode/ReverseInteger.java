package cn.wxy.leetcode;

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
}
