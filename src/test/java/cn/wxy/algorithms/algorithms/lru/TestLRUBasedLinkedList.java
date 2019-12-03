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
        LRUBasedLinkedList<Integer> lru = new LRUBasedLinkedList<>(5, true);

        lru.add(1);
        Assert.assertEquals(1, (int) lru.getEarliestElement());
        Assert.assertEquals(1, (int) lru.getLatestElement());

        lru.add(2);
        Assert.assertEquals(1, (int) lru.getEarliestElement());
        Assert.assertEquals(2, (int) lru.getLatestElement());

        lru.add(3);
        Assert.assertEquals(1, (int) lru.getEarliestElement());
        Assert.assertEquals(3, (int) lru.getLatestElement());

        lru.add(4);
        Assert.assertEquals(1, (int) lru.getEarliestElement());
        Assert.assertEquals(4, (int) lru.getLatestElement());

        lru.add(5);
        Assert.assertEquals(1, (int) lru.getEarliestElement());
        Assert.assertEquals(5, (int) lru.getLatestElement());

        lru.add(6);
        Assert.assertEquals(2, (int) lru.getEarliestElement());
        Assert.assertEquals(6, (int) lru.getLatestElement());

        lru.add(2);
        Assert.assertEquals(3, (int) lru.getEarliestElement());
        Assert.assertEquals(2, (int) lru.getLatestElement());
    }
}
