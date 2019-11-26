package cn.wxy.algorithms.datastructure.list;

import cn.wxy.datastructure.list.LinkedList;
import cn.wxy.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-11-26
 */
public class TestLinkedList {
    LinkedList<String> list;

    @Before
    public void init() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add("1");
        Assert.assertEquals(1, list.size());
        list.add(new LinkedList.Node<String>("2"));
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("1", list.getHead().val);
        Assert.assertEquals("2", list.getHead().next.val);
        list.add("3");
        list.add("4");
        list.add("5");
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void testRemove() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        list.add(node1);
        list.add(node2);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(true, list.remove(node1));
        Assert.assertEquals(true, list.remove("2"));
        Assert.assertEquals(false, list.remove("3"));
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testContain() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        list.add(node1);
        list.add(node2);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(true, list.contain(node1));
        Assert.assertEquals(true, list.contain("2"));
        Assert.assertEquals(false, list.contain("3"));
    }

    @Test
    public void testInsertBefore() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        LinkedList.Node<String> node3 = new LinkedList.Node<>("3");
        list.add(node3);
        list.insertBefore(node3, node1);
        list.insertBefore(node3, node2);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(node1, list.getHead());
        Assert.assertEquals(node2, list.getHead().next);
        Assert.assertEquals(node3, list.getHead().next.next);
    }

    @Test
    public void testInsertAfter() {
        LinkedList.Node<String> node1 = new LinkedList.Node<>("1");
        LinkedList.Node<String> node2 = new LinkedList.Node<>("2");
        LinkedList.Node<String> node3 = new LinkedList.Node<>("3");
        list.add(node1);
        list.insertAfter(node1, node2);
        list.insertAfter(node2, node3);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(node1, list.getHead());
        Assert.assertEquals(node2, list.getHead().next);
        Assert.assertEquals(node3, list.getHead().next.next);
    }
}
