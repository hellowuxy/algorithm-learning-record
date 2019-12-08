package cn.wxy.algorithms.algorithms.lru;

import cn.wxy.algorithms.lru.LRUBasedLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-12-03
 */
public class TestLRUBasedLinkedList {

    @Test
    public void test() {
        LRUBasedLinkedList<Integer> cache = new LRUBasedLinkedList<>(3);

        Assert.assertNull(cache.getEarliest());
        Assert.assertNull(cache.getLatest());

        cache.add(1); // 1
        cache.add(1); // 1
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(1, (int) cache.getLatest());

        cache.add(2); // 1->2
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(2, (int) cache.getLatest());
        cache.add(2); // 2->1
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(2, (int) cache.getLatest());

        cache.add(1); // 1->2
        Assert.assertEquals(2, (int) cache.getEarliest());
        Assert.assertEquals(1, (int) cache.getLatest());

        cache.add(3); // 3->1->2
        Assert.assertEquals(2, (int) cache.getEarliest());
        Assert.assertEquals(3, (int) cache.getLatest());

        Assert.assertEquals(2, (int) cache.add(4)); // 4->3->1
        Assert.assertEquals(1, (int) cache.getEarliest());
        Assert.assertEquals(4, (int) cache.getLatest());

        cache.add(5); // 5->4->3
        Assert.assertEquals(3, (int) cache.getEarliest());
        Assert.assertEquals(5, (int) cache.getLatest());

        cache.add(6); // 6->5->4
        Assert.assertEquals(4, (int) cache.getEarliest());
        Assert.assertEquals(6, (int) cache.getLatest());

        cache.add(4); // 4->6->5
        Assert.assertEquals(5, (int) cache.getEarliest());
        Assert.assertEquals(4, (int) cache.getLatest());
    }
}
