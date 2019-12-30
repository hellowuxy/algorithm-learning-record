package cn.wxy.algorithms;

import cn.wxy.datastructure.list.LinkedList;
import org.junit.BeforeClass;

/**
 * @author wxyidea
 * @create 2019-12-08
 */

public class Test {
    private static LinkedList<String> linkedList = new LinkedList<>();

    @BeforeClass
    public static void init() {
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("2");
        linkedList.add("2");
        linkedList.add("2");
        linkedList.add("1");
    }

    // 判断链表保存的字符串是否是回文字符串
    @org.junit.Test
    public void test() {
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        if (linkedList.size() % 2 == 0) {
            int half = linkedList.size() / 2;
            int index = 1;
            LinkedList.Node<String> node = linkedList.getHead();
            while (node != null) {
                if (index <= half) {
                    before.append(node.val);
                } else {
                    after.append(node.val);
                }
                index++;
                node = node.next;
            }

        } else {
            int half = linkedList.size() / 2 + 1;
            int index = 1;
            LinkedList.Node<String> node = linkedList.getHead();
            while (node != null) {
                if (index < half) {
                    before.append(node.val);
                } else if (index > half) {
                    after.append(node.val);
                }
                index++;
                node = node.next;
            }
        }
        // reverse 'after'
        StringBuilder reverseAfter = new StringBuilder();
        for (int i = after.length() - 1; i >= 0; i--) {
            reverseAfter.append(after.charAt(i));
        }
        // compare
        if (before.toString().equals(reverseAfter.toString())) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @org.junit.Test
    public void gg() {
        LinkedList.Node<String> slow = linkedList.getHead();
        LinkedList.Node<String> fast = linkedList.getHead();
        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        while (fast.next != null && fast.next.next != null) {
            before.append(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            //奇数
            slow = slow.next;
            while (slow != null) {
                after.append(slow.val);
                slow = slow.next;
            }
        } else {
            // 偶数
            before.append(slow.val);
            slow = slow.next;
            while (slow != null) {
                after.append(slow.val);
                slow = slow.next;
            }
        }

        // compare
        if (before.toString().equals(after.reverse().toString())) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
