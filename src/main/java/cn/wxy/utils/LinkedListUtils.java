package cn.wxy.utils;

import cn.wxy.datastructure.list.LinkedList;
import cn.wxy.datastructure.list.LinkedList.Node;

/**
 * 与链表有关的操作工具类
 *
 * @autor wxyidea
 * @create 2019-07-09
 **/
public class LinkedListUtils {

    /**
     * 将数组转换为链表
     *
     * @param arrays 数组
     * @return 链表
     */
    public static <T> LinkedList<T> arrayToLinkedList(T[] arrays) {
        if (arrays.length <= 0) {
            throw new RuntimeException("the length of array less than 1 !");
        }
        LinkedList<T> linkedList = new LinkedList<>();
        for (T array : arrays) {
            linkedList.add(array);
        }
        return linkedList;
    }

    /**
     * 打印单链表
     *
     * @param linkedList 链表
     */
    public static <T> void printList(LinkedList<T> linkedList) {
        Node<T> node = linkedList.getHead();
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf('-')));
    }
}
