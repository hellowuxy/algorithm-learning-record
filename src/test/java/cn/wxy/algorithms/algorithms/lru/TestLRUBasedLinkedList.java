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
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.add(6);
        Assert.assertEquals(2, (int) lru.getEarliestElement());
        Assert.assertEquals(6, (int) lru.getLatestElement());

        lru.add(2);
        Assert.assertEquals(3, (int) lru.getEarliestElement());
        Assert.assertEquals(2, (int) lru.getLatestElement());
    }
}
