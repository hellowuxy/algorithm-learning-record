package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.StringToInteger.atoi;

/**
 * @author wxyidea
 * @create 2019-11-26
 */
public class TestStringToInteger {
    @Test
    public void test(){
        Assert.assertEquals(0, atoi("+"));
        Assert.assertEquals(0, atoi("-"));
        Assert.assertEquals(123, atoi("123"));
        Assert.assertEquals(1234567890, atoi("1234567890"));
        Assert.assertEquals(Integer.MAX_VALUE, atoi("9876543210"));
        Assert.assertEquals(-1234567890, atoi("-1234567890"));
        Assert.assertEquals(Integer.MIN_VALUE, atoi("-9876543210"));
    }
}
