package com.guoguo.suan.linktable;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/27 下午12:47
 * @description：删除链表中的指定值
 * @modified By：
 * @version:
 */
public class DeleteConfirmValue {
    public static class Node {
        private int val;
        private Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteValue(Node head, int num) {

        //找到第一个不为num的头
        while (head != null) {
            if (head.val != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (num == cur.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}