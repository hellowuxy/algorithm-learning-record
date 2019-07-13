package cn.wxy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.Assert;

/**
 * 无重复的最长子串长度：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  示例 1:
 * 	  输入: "abcabcbb"
 * 	  输出: 3
 * 	  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 	  输入: "bbbbb"
 * 	  输出: 1
 * 	  解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 	  输入: "pwwkew"
 * 	  输出: 3
 * 	  解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 	       请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @autor wxyidea
 * @create 2019-07-12
 **/
public class LongestSubstring {

  /**
   * 解题思路：使用两层循环遍历字符串str，i表示外层循环索引、j表示内层循环索引 (0≤i<j≤n)，不断地移动i、j，寻找最长的子串；查找过程如下：
   *    （1）首先令i=0，j=i+1,longestSubstring表示当前已找到的最大子串，curStr表示当前子串(当前子串等于i到j之间的字符串（不包含第j个字符）)；
   *    （2）判断curString中是否已包含第j个字符，若不包含则转向（3），否则退出内层循环，并转向（4）；
   *    （3）将第j个字符追加到curStr中，然后令j++，回到（2）；
   *    （4）比较curStr与longestSubstring的长度，令longestSubstring指向其中的较大者，然后i++，j=i+1，回到（2）
   *    （5）当j=n时，退出内层循环，并比较子串与longestSubstring的长度，令longestSubstring指向其中的较大者，然后令i++，回到（2）
   *    （6）当i=n时，退出外层循环，返回longestSubstring的长度
   *
   * 时间复杂度：O(n^2)
   *
   * @param s 字符串
   * @return 最大子串长度
   */
  public static int lengthOflongestSubstring_way1(String s){
    String longestSubstring = "";
    for (int i = 0; i < s.length(); i++) {
      // 当前子串
      StringBuilder curStr = new StringBuilder();
      curStr.append(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        if (curStr.toString().contains(s.substring(j, j + 1))) break; // 退出内层循环
        else curStr.append(s.charAt(j)); // 追加新的字符到当前子串中
      }
      // 比较curStr与longestSubstring的长度，令longestSubstring指向其中的较大者
      if (curStr.toString().length() > longestSubstring.length())
        longestSubstring = curStr.toString();
    }
    return longestSubstring.length();
  }

  /**
   * 解题思路：滑动窗口（使用HashSet实现），我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = i）中。
   *        然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。
   *        此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案。
   *
   * 时间复杂度：O(2n) = O(n)，最糟糕的情况下，每个字符被 i 和 j 访问两次
   *
   * @param s
   * @return
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

  public static void main(String[] args) {
    Assert.assertEquals(3, lengthOflongestSubstring_way2("abcabcbb"));
    Assert.assertEquals(1, lengthOflongestSubstring_way2("bbbbb"));
    Assert.assertEquals(3, lengthOflongestSubstring_way2("pwwkew"));
    Assert.assertEquals(2, lengthOflongestSubstring_way2("aabb"));
    Assert.assertEquals(3, lengthOflongestSubstring_way2("dvdf"));
  }
}
