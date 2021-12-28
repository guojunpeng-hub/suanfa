package com.guoguo.suan.linktable;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/27 下午1:03
 * @description：双向链表实现栈和队列
 * @modified By：
 * @version:
 */
public class DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        private T val;
        private Node next;
        private Node last;

        public Node(T val) {
            this.val = val;
        }
    }

    public static class DoubleNodeQueue{
        //声明头部
        private Node head;
        //声明尾部
        private Node tail;

        public void addFromTop(int num){
            Node cur = new Node(num);
            if(head == null){
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromBottom(int num){
            Node cur = new Node(num);
            if(head == null){
                head = cur;
                tail = cur;
            }else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public Node popFromTop(){
            if(head == null){
                return null;
            }
            Node cur = head;
            if(head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur;
        }

        public Node popFromBottom(){
            if(tail == null){
                return null;
            }
            Node cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else {
                tail = tail.next;
                cur.next = null;
                tail.last = null;
            }
            return cur;
        }
    }
}