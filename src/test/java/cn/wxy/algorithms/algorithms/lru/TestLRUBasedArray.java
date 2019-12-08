package cn.wxy.algorithms.algorithms.lru;

import cn.wxy.algorithms.lru.LRUBasedArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-12-08
 */
public class TestLRUBasedArray {
    @Test
    public void test() {
        LRUBasedArray<Integer> cache = new LRUBasedArray<>(3);

        Assert.assertNull(cache.getEarliest());
        Assert.assertNull(cache.getLatest());

        cache.add(1); // [1]
        cache.add(1); // [1]
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(1, (int) cache.getLatest());

        cache.add(2); // [1,2]
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(2, (int) cache.getLatest());

        cache.add(1); // [2,1]
        Assert.assertEquals(2, (int) cache.getEarliest());
        Assert.assertEquals(1, (int) cache.getLatest());

        cache.add(2); // [1,2]
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(2, (int) cache.getLatest());

        cache.add(3); // [1,2,3]
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(3, (int) cache.getLatest());

        cache.add(4); // [2,3,4]
        Assert.assertEquals(2, (int) cache.getEarliest());
        Assert.assertEquals(4, (int) cache.getLatest());

        cache.add(2); // [3,4,2]
        Assert.assertEquals(3, (int) cache.getEarliest());
        Assert.assertEquals(2, (int) cache.getLatest());

        cache.add(5); // [4,2,5]
        Assert.assertEquals(4, (int) cache.getEarliest());
        Assert.assertEquals(5, (int) cache.getLatest());

        cache.add(4); // [2,5,4]
        Assert.assertEquals(2, (int) cache.getEarliest());
        Assert.assertEquals(4, (int) cache.getLatest());
    }
}
