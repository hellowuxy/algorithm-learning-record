package cn.wxy.leetcode;

/*
  判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

  示例 1:
    输入: 121
    输出: true

  示例 2:
    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

  示例 3:
    输入: 10
    输出: false
    解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */

import org.junit.Assert;

/**
 * 判断一个数是否为回文数
 *
 * @autor wxyidea
 * @create 2019-07-27
 **/
public class PalindromeNumber {

  /*
     解题思路：
        我们可以反转number得到reverseNumber，然后比较reverseNumber与number是否相等，但这样做有可能出现
     反转后的reverseNumber溢出的情况；
        因此，我们换一种方式，仅反转后半部分，然后比较reverseNumber和number的前半部分（如果我们从对称的角度看，
     回文数的左右两部分是完全对称的）。
     反转过程：从number的低位开始，逐位向前反转，当reverseNumber大于等于number时，表示已经得到反转的后半部分。

     注意两种边界情况：
        1) 负数不可能是回文数；
        2) 对于12321这种长度为奇数的回文数，由于中间的数反转前后一定相等，我们需要令reverseNumber除以10再与
           number前半部分（不包括中间的数字）比较。
   */
  public static boolean isPalindrome(int number) {
    // 负数不可能是回文数；大于0且末尾是0的整数也不可能是回文数
    if (number < 0 || (number % 10 == 0 && number != 0)) {
      return false;
    }
    int reverseNumber = 0;
    while (number > reverseNumber) {
      reverseNumber = reverseNumber * 10 + number % 10;
      number = number / 10;
    }
    return number == reverseNumber || number == (reverseNumber / 10);
  }

  public static void main(String[] args) {
    Assert.assertTrue(isPalindrome(12321));
    Assert.assertTrue(isPalindrome(1221));
    Assert.assertFalse(isPalindrome(12345));
    Assert.assertFalse(isPalindrome(-121));
  }
}
