package cn.wxy.leetcode;

/**
 * 判断一个数是否为回文数
 *
 * @autor wxyidea
 * @create 2019-07-27
 **/
public class PalindromeNumber {

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
}
