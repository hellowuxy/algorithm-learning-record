package cn.wxy.algorithms.datastructure.list;

import cn.wxy.datastructure.list.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-11-26
 */
public class TestLinkedList {
    private LinkedList<String> list;

    @Before
    public void init() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add("1");
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.contain("1"));
        Assert.assertEquals("1", list.getHead().next.val);

        list.add("2"); // 1->2
        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.contain("1"));
        Assert.assertTrue(list.contain("2"));
        Assert.assertEquals("1", list.getHead().next.val);
        Assert.assertEquals("2", list.getHead().next.next.val);

        list.add("3"); // 1->2->3
        Assert.assertEquals(3, list.size());
        Assert.assertTrue(list.contain("1"));
        Assert.assertTrue(list.contain("2"));
        Assert.assertTrue(list.contain("3"));
        Assert.assertEquals("1", list.getHead().next.val);
        Assert.assertEquals("2", list.getHead().next.next.val);
        Assert.assertEquals("3", list.getHead().next.next.next.val);
    }

    @Test
    public void testRemove() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        LinkedList.Node<String> node3 = new LinkedList.Node<>("3");
        list.add(node1);
        list.add(node2);
        list.add(node3); // 1->2->3

        Assert.assertTrue(list.remove("3")); // 1->2
        Assert.assertEquals(2,list.size());
        Assert.assertEquals("1", list.getHead().next.val);

        Assert.assertTrue(list.remove(node1)); // 2
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("2", list.getHead().next.val);
    }

    @Test
    public void testContain() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        list.add(node1);
        list.add(node2);
        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.contain(node1));
        Assert.assertTrue(list.contain("2"));
        Assert.assertFalse(list.contain("3"));
    }

    @Test
    public void testInsertBefore() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        LinkedList.Node<String> node3 = new LinkedList.Node<>("3");
        list.add(node3);
        Assert.assertTrue(list.insertBefore(node3, node1));
        Assert.assertTrue(list.insertBefore(node3, node2));
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(node1, list.getHead().next);
        Assert.assertEquals(node2, list.getHead().next.next);
        Assert.assertEquals(node3, list.getHead().next.next.next);
    }

    @Test
    public void testInsertAfter() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        LinkedList.Node<String> node3 = new LinkedList.Node<>("3");
        list.add(node1);
        Assert.assertTrue(list.insertAfter(node1, node2));
        Assert.assertTrue(list.insertAfter(node2, node3));
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(node1, list.getHead().next);
        Assert.assertEquals(node2, list.getHead().next.next);
        Assert.assertEquals(node3, list.getHead().next.next.next);
    }
}
