package cn.wxy.leetcode;

import java.util.HashSet;

/**
 * @autor wxyidea
 * @create 2019-07-12
 **/
public class LongestSubstring {

  /**
   * @param s 字符串
   * @return 最大子串长度
   */
  public static int lengthOflongestSubstring_way1(String s) {
    String longestSubstring = "";
    for (int i = 0; i < s.length(); i++) {
      // 当前子串
      StringBuilder curStr = new StringBuilder();
      curStr.append(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        if (curStr.toString().contains(s.substring(j, j + 1))) {
          break; // 退出内层循环
        } else {
          curStr.append(s.charAt(j)); // 追加新的字符到当前子串中
        }
      }
      // 比较curStr与longestSubstring的长度，令longestSubstring指向其中的较大者
      if (curStr.toString().length() > longestSubstring.length()) {
        longestSubstring = curStr.toString();
      }
    }
    return longestSubstring.length();
  }

  /**
   * @param s 字符串
   * @return 最大子串长度
   */
  public static int lengthOflongestSubstring_way2(String s) {
    int max = 0;
    HashSet<Character> set = new HashSet<>();
    int i = 0, j = 0;
    while (i < s.length() && j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        max = Math.max(max, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    max = (max < set.size()) ? set.size() : max;
    return max;
  }
}
