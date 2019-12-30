package cn.wxy.algorithms.datastructure.stack;

import cn.wxy.datastructure.stack.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayStack {
    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        // push
        Assert.assertTrue(stack.push(1));
        Assert.assertTrue(stack.push(2));
        Assert.assertTrue(stack.push(3));
        Assert.assertFalse(stack.push(4));
        Assert.assertEquals(3, stack.size());

        // pop
        Assert.assertEquals(3, (int) stack.pop());
        Assert.assertEquals(2, (int) stack.pop());
        Assert.assertEquals(1, (int) stack.pop());
        Assert.assertEquals(0, stack.size());

        // push + pop
        Assert.assertTrue(stack.push(4));
        Assert.assertEquals(4, (int) stack.pop());
    }
}
