package cn.wxy.leetcode;

import cn.wxy.datastructure.list.LinkedList.Node;
import cn.wxy.utils.LinkedListUtils;

/**
 * @autor wxyidea
 * @create 2019-07-09
 **/
public class AddTwoNumbers {

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node<Integer> p = l1;
        Node<Integer> q = l2;
        // 新链表头节点，该节点保存有效值
        Node<Integer> head = new Node<>(0);
        Node<Integer> cur = head;
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
                    Node<Integer> node = new Node<>(val);
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
                    Node<Integer> node = new Node<>(val);
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
                Node<Integer> node = new Node<>(val);
                cur.next = node;
                cur = node;
            } else {
                carry = 0;
                int val = sum;
                Node<Integer> node = new Node<>(val);
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
                Node<Integer> node = new Node<>(val);
                cur.next = node;
                cur = node;
                carry = 1;
            } else {
                int val = sum;
                Node<Integer> node = new Node<>(val);
                cur.next = node;
                cur = node;
                carry = 0;
            }
            q = q.next;
        }

        if (carry == 1) {
            // 追加一个新节点，保存最高位
            Node<Integer> node = new Node<>(1);
            cur.next = node;
        }

        return head;
    }

    public static Node addTwoNumbersAdvanced(Node l1, Node l2) {
        Node<Integer> p = l1;
        Node<Integer> q = l2;
        // 新链表头节点，该节点不保存有效值，仅用于简化程序处理逻辑
        Node<Integer> head = new Node(0);

        Node<Integer> cur = head;
        // 进位值
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            // 设置进位值
            carry = sum / 10;
            // 增加新节点
            Node<Integer> node = new Node<>(sum % 10);
            cur.next = node;
            cur = node;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry == 1) {
            // 保存最高位
            cur.next = new Node<>(1);
        }

        return head.next;
    }

    public static <T> void printList(Node<T> n) {
        Node node = n;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf('-')));
    }

    public static void main(String[] args) {
        Integer[] array1 = {9};
        Integer[] array2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};

        // test addTwoNumbers method
        Node head = addTwoNumbers(LinkedListUtils.arrayToLinkedList(array1).getHead(), LinkedListUtils.arrayToLinkedList(array2).getHead());
        printList(head);

        // test addTwoNumbersAdvanced method
        head = addTwoNumbersAdvanced(LinkedListUtils.arrayToLinkedList(array1).getHead(), LinkedListUtils.arrayToLinkedList(array2).getHead());
        printList(head);
    }
}
