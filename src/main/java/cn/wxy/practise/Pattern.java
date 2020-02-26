package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

/**
 * 贪心算法的应用：正则表达式匹配，假设只有 * 和 ？ 两种特殊字符
 */
public class Pattern {
  private char[] pattern;
  private boolean matched;

  public Pattern(char[] pattern) {
    this.pattern = pattern;
  }

  public boolean match(char[] target) {
    matched = false;
    doMatch(target, 0, pattern, 0);
    return matched;
  }

  /**
   * @param target  目标文本串
   * @param tIndex  目标文本串中当前待比较的字符索引
   * @param pattern 正则表达式
   * @param pIndex  正则表达式中当前待比较的字符索引
   */
  private void doMatch(char[] target, int tIndex, char[] pattern, int pIndex) {
    if (matched) return; // 已经匹配，不用再递归了

    if (pIndex == pattern.length) { // 正则表达式到末尾
      if (tIndex == target.length)
        matched = true; // 目标文本串到达末尾，说明匹配成功
      return;
    }

    if (pattern[pIndex] == '*') { // 匹配任意个字符
      for (int i = 0; i <= target.length - tIndex; i++) {
        doMatch(target, tIndex + i, pattern, pIndex + 1);
      }
    } else if (pattern[pIndex] == '?') { // 匹配0或1个字符
      doMatch(target, tIndex, pattern, pIndex + 1); // 匹配0个字符
      doMatch(target, tIndex + 1, pattern, pIndex + 1); // 匹配1个字符
    } else if (target[tIndex] == pattern[pIndex]) {
      doMatch(target, tIndex + 1, pattern, pIndex + 1);
    }
  }

  public static void main(String[] args) {
    Pattern pattern = new Pattern("abc".toCharArray());
    AssertUtils.assertTrue(pattern.match("abc".toCharArray()));
    AssertUtils.assertFalse(pattern.match("abcd".toCharArray()));
    AssertUtils.assertFalse(pattern.match("1abc".toCharArray()));

    pattern = new Pattern("a*".toCharArray());
    AssertUtils.assertTrue(pattern.match("abc".toCharArray()));
    AssertUtils.assertTrue(pattern.match("abcd".toCharArray()));
    AssertUtils.assertFalse(pattern.match("1abc".toCharArray()));

    pattern = new Pattern("a*bc".toCharArray());
    AssertUtils.assertTrue(pattern.match("abc".toCharArray()));
  }
}
