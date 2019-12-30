package cn.wxy.algorithms.utils;

import cn.wxy.datastructure.list.LinkedList;
import cn.wxy.datastructure.list.LinkedList.Node;
import cn.wxy.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxyidea
 * @create 2019-11-26
 */
public class TestLinkedUtils {
    @Test
    public void testArrayToLinkedList() {
        Integer[] arrays = new Integer[]{1, 2, 3};
        LinkedList<Integer> linkedList = LinkedListUtils.arrayToLinkedList(arrays);
        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(1,(int)linkedList.getHead().val);
        Assert.assertEquals(2,(int)linkedList.getHead().next.val);
        Assert.assertEquals(3,(int)linkedList.getHead().next.next.val);
        LinkedListUtils.printList(linkedList);
    }

    @Test
    public void testReverse(){
        // the length of linked list is 1
        Node<Integer> origin = new Node<>(1);
        LinkedListUtils.printList(origin);
        LinkedListUtils.printList(LinkedListUtils.reverse(origin));

        // the length of linked list is 2
        origin = new Node<>(1);
        for (int i = 2; i < 3; i++) {
            Node<Integer> node = new Node<>(i);
            node.next=origin;
            origin = node;
        }
        LinkedListUtils.printList(origin);
        LinkedListUtils.printList(LinkedListUtils.reverse(origin));

        // the length of linked list is 3
        origin = new Node<>(1);
        for (int i = 2; i < 4; i++) {
            Node<Integer> node = new Node<>(i);
            node.next=origin;
            origin = node;
        }
        LinkedListUtils.printList(origin);
        LinkedListUtils.printList(LinkedListUtils.reverse(origin));

        // the length of linked list is 4
        origin = new Node<>(1);
        for (int i = 2; i < 5; i++) {
            Node<Integer> node = new Node<>(i);
            node.next=origin;
            origin = node;
        }
        LinkedListUtils.printList(origin);
        LinkedListUtils.printList(LinkedListUtils.reverse(origin));
    }
}
