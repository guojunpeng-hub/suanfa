package com.guoguo.suan.likou;

import java.util.Arrays;

/**
 * @author xiaoguo
 * @date2022/1/11 0011 23:35
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        //最开始位置
        int start = 0;
        //结束位置
        int end = numbers.length-1;
        //逐渐向答案靠拢
        while (start<end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new  int[]{start+1,end+1};
            }else if(sum<target){
                start++;
            }else {
                end--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers,9)));
    }
}
