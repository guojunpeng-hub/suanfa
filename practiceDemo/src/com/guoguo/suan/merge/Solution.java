package com.guoguo.suan.merge;


import java.util.Arrays;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList(ListNode head) {
        return sortNode(head,null);
    }

    public static ListNode sortNode(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode listNode1 = sortNode(head, mid);
        ListNode listNode2 = sortNode(mid, tail);
        return merge(listNode1,listNode2);
    }

    public static ListNode merge(ListNode head1,ListNode head2){
        ListNode help = new ListNode(0);
        ListNode tmp = help;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (tmp1!=null && tmp2 != null){
            if(tmp1.val<=tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if(tmp1!=null){
            tmp.next = tmp1;
        }else if(tmp2 !=null) {
            tmp.next = tmp2;
        }
        return help.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0){
            return null;
        }else if (lists.length == 1){
            return lists[0];
        }
        int length = lists.length;
        int odd = length%2;
        ListNode ans = null;
        if(odd==1){
            for (int i = 1; i < lists.length; i++) {
                ans =mergeArray(mergeArray(lists[i],lists[++i]),ans);
            }
            ans = mergeArray(ans,lists[0]);
        }else {
            for (int i = 0; i < lists.length; i++) {
                ans =mergeArray(mergeArray(lists[i],lists[++i]),ans);
            }
        }
        return ans;
    }

    public static ListNode mergeArray(ListNode listNode1,ListNode listNode2){
        if(listNode1 ==null || listNode2 == null){
            return listNode1!=null?listNode1:listNode2;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, tmp1 = listNode1, tmp2 = listNode2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tail.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tail.next = tmp2;
                tmp2 = tmp2.next;
            }
            tail = tail.next;
        }
        tail.next = (tmp1 != null ? tmp1 : tmp2);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;

        ListNode tmp = listNode;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        listNode = sortList(listNode);
        tmp = listNode;
        System.out.println("=================================");
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        System.out.println("=================================");

        ListNode[] arr = new ListNode[]{listNode,listNode};
        ListNode listNode4 = mergeKLists(arr);
        ListNode tmp1 = listNode4;
        while (tmp1!=null){
            System.out.println("oo："+tmp1.val);
            tmp1 = tmp1.next;
        }
    }
}