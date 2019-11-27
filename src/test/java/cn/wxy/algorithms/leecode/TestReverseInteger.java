package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.ReverseInteger.reverseInteger;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestReverseInteger {
    @Test
    public void test() {
        Assert.assertEquals(123, reverseInteger(321));
        Assert.assertEquals(0, reverseInteger(Integer.MAX_VALUE));
        Assert.assertEquals(-187, reverseInteger(-781));
        Assert.assertEquals(0, reverseInteger(Integer.MIN_VALUE));
    }
}
