package cn.wxy.leetcode;

/*
  请你来实现一个 atoi 函数，使其能将字符串转换成整数。

  首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

  当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
  作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

  该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

  注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
  在任何情况下，若函数不能进行有效的转换时，请返回 0。

  说明：
    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
    如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

  示例 1:
    输入: "42"
    输出: 42

  示例 2:
    输入: "   -42"
    输出: -42
    解释: 第一个非空白字符为 '-', 它是一个负号。
         我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
  示例 3:
    输入: "4193 with words"
    输出: 4193
    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

  示例 4:
    输入: "words and 987"
    输出: 0
    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
         因此无法执行有效的转换。

  示例 5:
    输入: "-91283472332"
    输出: -2147483648
    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
         因此返回 INT_MIN (−231) 。
 */

/**
 * 字符串转整数
 *
 * @autor wxyidea
 * @create 2019-07-27
 **/
public class StringToInteger {

  /*
    解题思路：遍历字符串str，当遇到的字符属于 {'-','+',['0'~'9']}其中一个，使用一个StringBuilder对象 digits
    保存该字符，否则终止循环；最后对新得到的字符串digitsStr使用 Integer.parseInt() 方法进行转换，若转换失败则
    表示整数溢出，返回最大值或最小值即可。

    注意以下2种边界情况：
      1) digitsStr长度为0，说明未找到合适的整数，返回0；
      2) digitsStr长度为1，且digitsStr等于 '-' 或 '+'，返回0。
   */
  public static int atoi(String str) {
    if (str == null || str.trim().length() == 0) {
      return 0;
    }

    //移除首尾的空格
    str = str.trim();

    StringBuilder digits = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (i == 0 && ch == '-') {
        digits.append(ch);
      } else if (i == 0 && ch == '+') {
        digits.append(ch);
      } else if (ch >= '0' && ch <= '9') {
        digits.append(ch);
      } else {
        break;
      }
    }

    String digitsStr = digits.toString();

    if (digitsStr.length() == 0) {
      return 0;
    }

    if (digitsStr.length() == 1 && ("-".equals(digitsStr) || "+".equals(digitsStr))) {
      return 0;
    }

    int num;
    try {
      num = Integer.parseInt(digitsStr);
    } catch (NumberFormatException e) {
      // 转换失败，表示溢出，直接返回最大值或最小值
      return digitsStr.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    return num;
  }
}
