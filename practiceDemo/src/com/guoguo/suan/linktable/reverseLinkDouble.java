package com.guoguo.suan.linktable;

/**
 * @author xiaoguo
 * @date2021/12/26 0026 21:07
 */
public class reverseLinkDouble {
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 1 -> 2 -> 3
     * 1 <- 2 <- 3
     * 双向链表反转
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleLink(DoubleNode head){
        DoubleNode next = null;
        DoubleNode pre = null;

        while (pre != null){
            //记住下一个
            next = head.next;
            //指向之前
            head.next = pre;
            //指向之后
            head.last = next;

            pre = head;
            //往下找
            head = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        DoubleNode node = new DoubleNode(1);
        DoubleNode node1 = new DoubleNode(2);
        DoubleNode node2 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);

        node.next = node1;
        node1.last = node;
        node1.next = node2;
        node2.last = node1;
        node2.next = node4;
        node4.last = node2;

        DoubleNode cur = node;
        while (cur != null){
            System.out.println(node.value+": 之前"+node.last+",之后"+node.next);
            cur = cur.next;
        }
        cur = reverseDoubleLink(node);
        while (cur != null){
            System.out.println(node.value+": 之前"+node.last+",之后"+node.next);
            cur = cur.next;

        }
    }
}
