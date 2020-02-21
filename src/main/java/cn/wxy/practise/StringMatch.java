package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

import java.util.Arrays;

/**
 * @author hellowuxy
 * @create 2020-02-17
 */
public class StringMatch {
  /**
   * BF算法判断字符串是否匹配
   *
   * @param master  主串
   * @param pattern 模式串
   * @return 返回主串与模式串第一个匹配的字符的位置
   */
  public static int way_BF(String master, String pattern) {
    // 子串数量
    int count = master.length() - pattern.length() + 1;
    for (int i = 0; i < count; i++) {
      String sub = master.substring(i, i + pattern.length());

      boolean match = true;
      for (int j = 0; j < pattern.length(); j++) {
        if (sub.charAt(j) != pattern.charAt(j)) {
          match = false;
          break;
        }
      }

      if (match) {
        return i;
      }
    }
    return -1;
  }

  /**
   * RK算法判断字符串是否匹配
   *
   * @param master  主串
   * @param pattern 模式串
   * @return 返回主串与模式串第一个匹配的字符的位置
   */
  public static int way_RK(String master, String pattern) {
    // 模式串hash值
    int patternHashValue = 0;
    for (int i = 0; i < pattern.length(); i++) {
      patternHashValue += pattern.charAt(i) - '0';
    }

    // 子串数量
    int count = master.length() - pattern.length() + 1;
    for (int i = 0; i < count; i++) {
      String sub = master.substring(i, i + pattern.length());
      // 计算子串的hash值
      int hashValue = 0;
      for (int j = 0; j < sub.length(); j++) {
        hashValue += sub.charAt(j) - '0';
      }
      // compare hash value
      if (patternHashValue == hashValue) {
        return i;
      }
    }

    return -1;
  }

  //------------------ BM算法 start -----------------------

  /**
   * 单独使用坏字符规则的实现
   *
   * @param origin
   * @param pattern
   */
  public static int bm_1(String origin, String pattern) {
    char[] originCharArr = origin.toCharArray();
    char[] patternCharArr = pattern.toCharArray();
    // 坏字符的hash表
    int[] hashTable = new int[256];
    // 初始化
    Arrays.fill(hashTable, -1);

    for (int i = 0; i < patternCharArr.length; i++) {
      int ascii = patternCharArr[i];
      hashTable[ascii] = i;
    }

    int i = 0;
    while (i <= origin.length() - pattern.length()) {
      int j = pattern.length() - 1;
      while (j >= 0 && patternCharArr[j] == originCharArr[i + j]) j--;

      if (j < 0) {
        // 成功匹配
        return i;
      }

      // 计算滑动位置
      i = i + (j - hashTable[(int) originCharArr[i + j]]);
    }
    return -1;
  }
  //------------------ BM算法 end -----------------------

  public static void main(String[] args) {
    AssertUtils.assertEqual(0, way_BF("aaaab", "aa"));
    AssertUtils.assertEqual(3, way_BF("aaaab", "ab"));
    AssertUtils.assertEqual(-1, way_BF("aaaab", "abc"));

    AssertUtils.assertEqual(0, way_RK("aaaab", "aa"));
    AssertUtils.assertEqual(3, way_RK("aaaab", "ab"));
    AssertUtils.assertEqual(-1, way_RK("aaaab", "abc"));

    AssertUtils.assertEqual(0, bm_1("aaaab", "aa"));
    AssertUtils.assertEqual(3, bm_1("aaaab", "ab"));
    AssertUtils.assertEqual(-1, bm_1("aaaab", "ac"));
    AssertUtils.assertEqual(2, bm_1("hello", "ll"));
  }
}
