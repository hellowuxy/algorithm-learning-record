package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

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
   * @return
   */
  public static boolean way_BF(String master, String pattern) {
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
        return true;
      }
    }
    return false;
  }

  /**
   * RK算法判断字符串是否匹配
   *
   * @param master  主串
   * @param pattern 模式串
   * @return
   */
  public static boolean way_RK(String master, String pattern) {
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
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    AssertUtils.assertTrue(way_BF("aaaab", "aa"));
    AssertUtils.assertTrue(way_BF("aaaab", "ab"));
    AssertUtils.assertFalse(way_BF("aaaab", "abc"));

    AssertUtils.assertTrue(way_RK("aaaab", "aa"));
    AssertUtils.assertTrue(way_RK("aaaab", "ab"));
    AssertUtils.assertFalse(way_RK("aaaab", "abc"));
  }
}
