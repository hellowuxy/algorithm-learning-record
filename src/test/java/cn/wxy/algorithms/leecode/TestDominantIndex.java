package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.DominantIndex.dominantIndex;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestDominantIndex {
    @Test
    public void test(){
        int[] arrays3 = {0, 0, 0, 1};
        Assert.assertEquals(3, dominantIndex(arrays3));
        int[] arrays4 = {3, 6, 1, 0};
        Assert.assertEquals(1, dominantIndex(arrays4));
        int[] arrays5 = {1, 2, 3, 4};
        Assert.assertEquals(-1, dominantIndex(arrays5));
    }
}
