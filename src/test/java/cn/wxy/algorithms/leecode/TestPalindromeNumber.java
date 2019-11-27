package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.PalindromeNumber.isPalindrome;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestPalindromeNumber {
    @Test
    public void test() {
        Assert.assertTrue(isPalindrome(12321));
        Assert.assertTrue(isPalindrome(1221));
        Assert.assertFalse(isPalindrome(12345));
        Assert.assertFalse(isPalindrome(-121));
    }
}
