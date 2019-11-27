package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.LongestSubstring.lengthOflongestSubstring_way2;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestLongestSubstring {
    @Test
    public void test() {
        Assert.assertEquals(3, lengthOflongestSubstring_way2("abcabcbb"));
        Assert.assertEquals(1, lengthOflongestSubstring_way2("bbbbb"));
        Assert.assertEquals(3, lengthOflongestSubstring_way2("pwwkew"));
        Assert.assertEquals(2, lengthOflongestSubstring_way2("aabb"));
        Assert.assertEquals(3, lengthOflongestSubstring_way2("dvdf"));
    }
}
