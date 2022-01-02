package com.guoguo.suan.linktable;

import java.util.Stack;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/28 下午9:31
 * @description：栈实现队列
 * @modified By：
 * @version:
 */
public class TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        //负责压数据
        private Stack<Integer> pushdata;
        //负责弹出
        private Stack<Integer> popdata;

        public TwoStacksQueue() {
            this.pushdata = new Stack<>();
            this.popdata = new Stack<>();
        }

        /**
         * 每次操作都要处理最新要弹出的数据
         */
        public void pushToPop() {
            if (popdata.empty()) {
                while (!pushdata.empty()) {
                    popdata.push(pushdata.pop());
                }
            }
        }

        public void add(int num) {
            pushdata.push(num);
            pushToPop();
        }

        /**
         * 弹出
         *
         * @return
         */
        public int poll() {
            if (pushdata.isEmpty() && popdata.isEmpty()) {
                throw new RuntimeException("空空了！");
            }
            pushToPop();
            return popdata.pop();
        }

        public int peek() {
            if (pushdata.isEmpty() && popdata.isEmpty()) {
                throw new RuntimeException("空空了！");
            }
            pushToPop();
            return popdata.peek();
        }

    }

    public static void main(String[] args) {
        TwoStacksQueue stacksQueue = new TwoStacksQueue();
        stacksQueue.add(1);
        stacksQueue.add(2);
        stacksQueue.add(3);
        System.out.println(stacksQueue.peek());
        System.out.println(stacksQueue.poll());
        System.out.println(stacksQueue.peek());
        System.out.println(stacksQueue.poll());
        stacksQueue.add(4);
        System.out.println(stacksQueue.peek());
        System.out.println(stacksQueue.poll());
        System.out.println(stacksQueue.poll());
    }
}