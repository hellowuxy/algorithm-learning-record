package cn.wxy.algorithms.utils;

import cn.wxy.datastructure.list.LinkedList;
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
}
