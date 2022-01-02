package com.guoguo.suan.linktable;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/28 下午1:19
 * @description：数组实现栈和队列
 * @modified By：
 * @version:
 */
public class RingArray {
    public static class Myqueue {
        private int[] arr;
        private int size;
        private int pushi;
        private int polli;
        private int limit;

        public Myqueue(int limit) {
            this.arr = new int[limit];
            this.size = 0;
            this.pushi = 0;
            this.polli = 0;
            this.limit = limit;
        }

        /**
         * 推
         *
         * @param num
         */
        public void push(int num) {
            if (size == limit) {
                throw new RuntimeException("我已经满了，加不下了！");
            }
            arr[pushi] = num;
            size++;
            pushi = addIndex(pushi);
        }

        public int pop(int num) {
            if (size == 0) {
                throw new RuntimeException("我已经空了，别拿了！");
            }
            int res = arr[polli];
            size--;
            polli = addIndex(pushi);
            return res;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int addIndex(int index) {
            return index < limit - 1 ? index++ : 0;
        }
    }
}