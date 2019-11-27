package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.StockTrade.maxProfit;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestStockTrade {
    @Test
    public void test() {
        Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
