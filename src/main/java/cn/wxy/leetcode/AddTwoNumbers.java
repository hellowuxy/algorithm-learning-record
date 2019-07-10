package cn.wxy.leetcode;

import cn.wxy.datastructure.SingleListNode;
import cn.wxy.utils.LinkedListUtils;

/**
 * 两数相加：
 *    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   输出：7 -> 0 -> 8
 *   原因：342 + 465 = 807
 *
 *
 * 解题思路请参考 https://leetcode-cn.com/articles/add-two-numbers
 *
 * @autor wxyidea
 * @create 2019-07-09
 **/
public class AddTwoNumbers {

  /**
   * 时间复杂度 O(max{m,n}),m 表示链表 l1 的长度，n 表示链表 l2 的长度
   *
   * @param l1 链表
   * @param l2 链表
   * @return 新链表
   */
  public static SingleListNode addTwoNumbers(SingleListNode l1, SingleListNode l2) {
    SingleListNode<Integer> p = l1;
    SingleListNode<Integer> q = l2;
    // 新链表头节点，该节点保存有效值
    SingleListNode<Integer> head = new SingleListNode<>(0);
    SingleListNode<Integer> cur = head;
    // 进位
    int carry = 0;
    while (p != null && q != null) {
      int sum = p.val + q.val + carry;
      if (sum > 9) {
        // 两数之和大于9，进位值为1
        carry = 1;

        // 计算新节点的val
        int val = sum - 10;
        if (cur == head) {
          cur.val = val;
        } else {
          SingleListNode<Integer> node = new SingleListNode<>(val);
          cur.next = node;
          cur = node;
        }
      } else {
        // 两数之和小于10，进位值为0
        carry = 0;

        // 计算新节点的val
        int val = sum;
        if (cur == head) {
          cur.val = val;
        } else {
          SingleListNode<Integer> node = new SingleListNode<>(val);
          cur.next = node;
          cur = node;
        }
      }
      p = p.next;
      q = q.next;
    }

    // 计算剩余的l1
    while (p != null) {
      int sum = p.val + carry;
      if (sum > 9) {
        carry = 1;
        // 计算新的节点
        int val = sum - 10;
        SingleListNode<Integer> node = new SingleListNode<>(val);
        cur.next = node;
        cur = node;
      } else {
        carry = 0;
        int val = sum;
        SingleListNode<Integer> node = new SingleListNode<>(val);
        cur.next = node;
        cur = node;
      }
      p = p.next;
    }

    // 计算剩余的l2
    while (q != null) {
      int sum = q.val + carry;
      if (sum > 9) {
        int val = sum - 10;
        SingleListNode<Integer> node = new SingleListNode<>(val);
        cur.next = node;
        cur = node;
        carry = 1;
      } else {
        int val = sum;
        SingleListNode<Integer> node = new SingleListNode<>(val);
        cur.next = node;
        cur = node;
        carry = 0;
      }
      q = q.next;
    }

    if (carry == 1) {
      // 追加一个新节点，保存最高位
      SingleListNode<Integer> node = new SingleListNode<>(1);
      cur.next = node;
    }

    return head;
  }

  /**
   * 该方法是对addTwoNumbers的优化，代码更简洁。
   *
   * 时间复杂度 O(max{m,n}),m 表示链表 l1 的长度，n 表示链表 l2 的长度
   *
   * @param l1 链表
   * @param l2 链表
   * @return 新链表
   */
  public static SingleListNode addTwoNumbersAdvanced(SingleListNode l1, SingleListNode l2) {
    SingleListNode<Integer> p = l1;
    SingleListNode<Integer> q = l2;
    // 新链表头节点，该节点不保存有效值，仅用于简化程序处理逻辑
    SingleListNode<Integer> head = new SingleListNode(0);

    SingleListNode<Integer> cur = head;
    // 进位值
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = x + y + carry;
      // 设置进位值
      carry = sum / 10;
      // 增加新节点
      SingleListNode<Integer> node = new SingleListNode<>(sum % 10);
      cur.next = node;
      cur = node;
      if(p != null) p = p.next;
      if(q != null) q = q.next;
    }

    if (carry == 1) {
      // 保存最高位
      cur.next = new SingleListNode<>(1);
    }

    return head.next;
  }

  public static void main(String[] args) {
    int[] array1 = {9};
    int[] array2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};

    // test addTwoNumbers method
    SingleListNode node1 = addTwoNumbers(LinkedListUtils.arrayToLinkedList(array1),
            LinkedListUtils.arrayToLinkedList(array2));
    LinkedListUtils.printList(node1);

    // test addTwoNumbersAdvanced method
    SingleListNode node2 = addTwoNumbersAdvanced(LinkedListUtils.arrayToLinkedList(array1),
            LinkedListUtils.arrayToLinkedList(array2));
    LinkedListUtils.printList(node2);
  }
}