package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;
import java.math.BigInteger;

/*
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *  假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  示例 1:
 *     输入: [1,2,3]
 *     输出: [1,2,4]
 *     解释: 输入数组表示数字 123。
 *
 *  示例 2:
 *     输入: [4,3,2,1]
 *     输出: [4,3,2,2]
 *     解释: 输入数组表示数字 4321。
 */

/**
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class PlusOne {

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
      if (arrays[i] < 9) {
        flag = false;
      }
    }
    if (flag) {
      return copy;
    }

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
      if (arrays[i] != 0) {
        return arrays;
      }
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
    for (int num : arrays) {
      sb.append(num);
    }

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
    // 测试plusOne方法
    int[] array6 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    // int[] array6 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 1};
    // int[] array6 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    ArrayUtils.printArray(array6);
    array6 = plusOne_way3(array6);
    ArrayUtils.printArray(array6);
  }
}
