package cn.wxy.algorithms.datastructure.list;

import cn.wxy.datastructure.list.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-11-30
 */
public class TestDoubleLinkedList {
    @Test
    public void testAdd() {
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>();
        linkedList.add("1");
        Assert.assertEquals(linkedList.first(), linkedList.last());

        linkedList.add(new DoubleLinkedList.DLNode<>("2"));
        Assert.assertEquals("1", linkedList.first().value);
        Assert.assertEquals("2", linkedList.last().value);

        linkedList.add("3");
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testContain() {
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>();
        linkedList.add("1");
        DoubleLinkedList.DLNode<String> node = new DoubleLinkedList.DLNode<>("2");
        linkedList.add(node);
        Assert.assertTrue(linkedList.contain(node));
        Assert.assertTrue(linkedList.contain("1"));
        Assert.assertFalse(linkedList.contain("3"));
    }

    @Test
    public void testRemove() {
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>();
        DoubleLinkedList.DLNode<String> node1 = new DoubleLinkedList.DLNode<>("1");
        DoubleLinkedList.DLNode<String> node2 = new DoubleLinkedList.DLNode<>("2");
        DoubleLinkedList.DLNode<String> node3 = new DoubleLinkedList.DLNode<>("3");
        DoubleLinkedList.DLNode<String> node4 = new DoubleLinkedList.DLNode<>("4");
        DoubleLinkedList.DLNode<String> node5 = new DoubleLinkedList.DLNode<>("5");
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);

        linkedList.remove(node3);
        Assert.assertEquals(node1, linkedList.first());
        Assert.assertEquals(node5, linkedList.last());

        linkedList.remove(node5);
        Assert.assertEquals(node4, linkedList.last());

        linkedList.remove(node1);
        Assert.assertEquals(node2, linkedList.first());

        linkedList.remove(node2);
        linkedList.remove(node4);
        Assert.assertEquals(0, linkedList.size());
        Assert.assertNull(linkedList.first());
        Assert.assertNull(linkedList.last());
    }

    @Test
    public void testInsert() {
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<>();
        DoubleLinkedList.DLNode<String> node0 = new DoubleLinkedList.DLNode<>("0");
        DoubleLinkedList.DLNode<String> node1 = new DoubleLinkedList.DLNode<>("1");
        DoubleLinkedList.DLNode<String> node2 = new DoubleLinkedList.DLNode<>("2");
        DoubleLinkedList.DLNode<String> node3 = new DoubleLinkedList.DLNode<>("3");
        DoubleLinkedList.DLNode<String> node4 = new DoubleLinkedList.DLNode<>("4");
        DoubleLinkedList.DLNode<String> node5 = new DoubleLinkedList.DLNode<>("5");

        linkedList.add(node2);

        linkedList.insertBefore(node2, node1);
        Assert.assertEquals(node1, linkedList.first());
        Assert.assertEquals(node2, linkedList.last());

        linkedList.insertAfter(node2, node5);
        Assert.assertEquals(node1, linkedList.first());
        Assert.assertEquals(node5, linkedList.last());

        linkedList.insertAfter(node2, node3);
        Assert.assertEquals(4, linkedList.size());

        linkedList.insertBefore(node5, node4);
        linkedList.insertBefore(node1, node0);

        DoubleLinkedList.DLNode<String> cursor = linkedList.first();
        StringBuilder sb = new StringBuilder();
        while (cursor != null) {
            sb.append(cursor.value).append("->");
            cursor = cursor.next;
        }
        String result = sb.toString().substring(0, sb.lastIndexOf("-"));
        Assert.assertEquals("0->1->2->3->4->5", result);
    }
}
