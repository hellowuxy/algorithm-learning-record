package cn.wxy.algorithms.datastructure.queue;

import cn.wxy.datastructure.queue.ArrayQueue;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayQueue {
    @Test
    public void test() {
        ArrayQueue<String> queue = new ArrayQueue<>(3);
        // enqueue
        Assert.assertTrue(queue.enqueue("a"));
        Assert.assertTrue(queue.enqueue("b"));
        Assert.assertTrue(queue.enqueue("c"));
        Assert.assertFalse(queue.enqueue("d"));
        Assert.assertEquals(3,queue.size());
        System.out.println(queue.toString());

        // dequeue
        Assert.assertEquals("a", queue.dequeue());
        Assert.assertEquals("b", queue.dequeue());
        Assert.assertEquals("c", queue.dequeue());
        Assert.assertNull(queue.dequeue());
        Assert.assertEquals(0,queue.size());
        System.out.println(queue.toString());

        // enqueue + dequeue
        Assert.assertTrue(queue.enqueue("a"));
        Assert.assertTrue(queue.enqueue("b"));
        Assert.assertTrue(queue.enqueue("c"));
        Assert.assertEquals("a", queue.dequeue());
        Assert.assertTrue(queue.enqueue("d"));
        System.out.println(queue.toString());
    }
}
