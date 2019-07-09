package cn.wxy.utils;

import cn.wxy.datastructure.SingleListNode;

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
   * @return 链表首节点
   */
  public static SingleListNode arrayToLinkedList(int[] arrays) {
    if (arrays.length <= 0)
      throw new RuntimeException("the length of array less than 1 !");
    SingleListNode first = new SingleListNode(arrays[0]);
    SingleListNode current = first;
    for (int i = 1; i < arrays.length; i++) {
      SingleListNode node = new SingleListNode(arrays[i]);
      current.next = node;
      current = node;
    }
    return first;
  }

  /**
   * 打印单链表
   *
   * @param singleListNode
   */
  public static void printList(SingleListNode singleListNode) {
    SingleListNode node = singleListNode;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.val).append("->");
      node = node.next;
    }
    System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf('-')));
  }
}
