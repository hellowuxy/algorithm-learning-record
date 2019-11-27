package cn.wxy.algorithms.leecode;

import org.junit.Assert;
import org.junit.Test;

import static cn.wxy.leetcode.PivotIndex.pivotIndex;
import static cn.wxy.leetcode.PivotIndex.pivotIndexOptimized;

/**
 * @author wxyidea
 * @create 2019-11-27
 */
public class TestPivotIndex {
    @Test
    public void test(){
        // 测试pivotIndex和pivotIndexOptimized
        int[] array1 = {1, 7, 3, 6, 5, 6};
        Assert.assertEquals(3, pivotIndex(array1));
        Assert.assertEquals(3, pivotIndexOptimized(array1));

        // 比较pivotIndex和pivotIndexOptimized的执行效率
        int[] array2 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array2[i] = i;
        }
        long s1 = System.currentTimeMillis();
        pivotIndex(array2);
        long s2 = System.currentTimeMillis();
        System.out.printf("优化前，查找中间索引耗时{%d}ms\n", (s2 - s1));

        s1 = System.currentTimeMillis();
        pivotIndexOptimized(array2);
        s2 = System.currentTimeMillis();
        System.out.printf("优化后，查找中间索引耗时{%d}ms\n", (s2 - s1));
    }
}
