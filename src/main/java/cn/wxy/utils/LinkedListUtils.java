package cn.wxy.utils;

import cn.wxy.datastructure.list.LinkedList;
import cn.wxy.datastructure.list.LinkedList.Node;

/**
 * 单链表工具类
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
     * reverse linked list
     *
     * @param linkedList origin linked list
     * @param <T>        data type stored in linked list
     * @return reversed linked list
     */
    public static <T> Node<T> reverse(Node<T> linkedList) {
        Node<T> cur = linkedList;
        Node<T> prev = null;
        while (cur != null) {
            Node<T> node = cur;
            cur = cur.next;
            node.next = prev;
            prev = node;
        }
        return prev;
    }

    /**
     * 打印单链表
     *
     * @param linkedList 链表
     */
    public static <T> void printList(LinkedList<T> linkedList) {
        Node<T> node = linkedList.getHead().next;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf('-')));
    }

    /**
     * 打印单链表
     *
     * @param linkedList 链表
     */
    public static <T> void printList(Node<T> linkedList) {
        Node<T> node = linkedList;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.toString().substring(0, sb.lastIndexOf("-")));
    }
}
