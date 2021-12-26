package com.guoguo.suan.linktable;


/**
 * @author  xiaoguo
 * @date2021/12/26 0026 17:28
 */
public class reverseLink {

    public static   class Node {
        //值
        private  int val;
        //下一节点
        private  Node next;

        public Node(int date){
            val = date;
        }
    }

    /**
     * 1 -> 2 -> 3 反转前
     * 反转过程  1 <- 2 <- 3
     * @param head
     * @return
     */
    public static Node reverseLinkList(Node head){
        Node next = null;
        //记录上一节点
        Node pre = null;
        while (head!=null){
            //指向下一节点，以便循环
            next = head.next;
            // 指向反向节点
            head.next = pre;

            //先一节点的反向节点
            pre = head;
            //将暂存的指向即将循环的节点
            head = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println("翻转前：");
        Node cur = node;
        while (cur!=null){
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println("\n翻转后：");
        Node node4 = reverseLinkList(node);
        cur = node4;
        while (cur!=null){
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

}
