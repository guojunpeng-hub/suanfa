package com.guoguo.suan.linktable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/29 下午12:41
 * @description：队列实现栈功能
 * @modified By：
 * @version:
 */
public class TwoQueueImplementStack {
    public static class MyStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public MyStack() {
            this.queue = new LinkedList();
            this.help = new LinkedList();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }

        public void push(T val){
            queue.offer(val);
        }

        public T poll(){
            while (queue.size()>1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public T peek(){
            while (queue.size()>1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
    }
}