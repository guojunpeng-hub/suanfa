package com.guoguo.suan.likou;

import java.util.Arrays;

/**
 * @author xiaoguo
 * @date2022/1/10 0010 23:39
 */
public class Rotate {
    public static   void rotate(int[] nums, int k) {
        //数组长度
        int length = nums.length;
        //实际行进步数
        int step = k%length;
        //开始运动的坐标
        int startIndex = length-step;
        //暂存行走步数的坐标
        int[] arr = new int[step];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[startIndex+i];
        }
        //将剩余数组分别向后平移step步
        for (int i = startIndex-1; i >=0; i--) {
            nums[i+step] = nums[i];
        }
        //将暂存的行走步数略过的索引赋值到最前侧
        for (int i = 0; i<step; i++) {
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
