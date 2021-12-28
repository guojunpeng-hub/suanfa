package com.guoguo.suan.linktable;

import java.util.Stack;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/28 下午8:59
 * @description：最小栈
 * @modified By：
 * @version:
 */
public class GetMinStack {
    public static class MyStack {
        private Stack<Integer> data;
        private Stack<Integer> minData;

        public MyStack() {
            this.data = new Stack<>();
            this.minData = new Stack<>();
        }

        /**
         * 压入值
         * @param num
         */
        public void push(int num) {
            if (isEmpty()) {
                minData.push(num);
            } else if (num < getMin()) {
                minData.push(num);
            }
            data.push(num);
        }

        /**
         * 弹出值
         * @return
         */
        public Integer pop() {
            if(isEmpty()){
                throw new RuntimeException("空空如夜！");
            }
            int val = data.pop();
            if(val == getMin()){
                minData.pop();
            }
            return val;
        }

        /**
         * 获取当前最小值
         * @return
         */
        public Integer getMin() {
            return minData.peek();
        }

        /**
         * 是否为空
         * @return
         */
        public boolean isEmpty() {
            return minData.isEmpty();
        }
    }
}