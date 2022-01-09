package com.guoguo.suan.merge;

/**
 * @author xiaoguo
 * @Description https://leetcode.com/problems/count-of-range-sum/
 * 力扣原题直接看
 * 解题思路，根据前缀和归并排序解
 * @date2022/1/3 0003 16:33
 */
public class CountOfRangeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{0,-3,-3,1,1,2};
            System.out.println(countRangeSum(arr,3,5));
        }

        public static int countRangeSum(int[] arr,int lowwer,int upper) {
            if (arr == null || arr.length == 0) {
            return 0;
        }
        //前缀和
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return process(sum,0,arr.length-1,lowwer,upper);
    }

    public static int process(long[] arr, int L, int R, int lowwer, int upper) {
        //边界条件
        if (L == R) {
            //判断当前值是否在这个区间内
            return arr[L] >= lowwer && arr[L] <= upper ? 1 : 0;
        }
        //中间点
        int M = L + ((R - L) >> 1);
        return process(arr,L,M,lowwer,upper)+
                process(arr,M+1,R,lowwer,upper)+merge(arr,L,R,M,lowwer,upper);
    }

    public static int merge(long[] arr, int L, int R, int M, int loweer, int upper) {
        int ans = 0;
        //移动边界条件，左移点
        int windowL = L;
        //移动边界条件，右移点
        int windowR = L;

        for (int i = M + 1; i <= R; i++) {
            //判断左侧值是否在最低区间的边界条件
            long max = arr[i] - loweer;
            //判断左侧值是否在最高区间的边界条件
            long min = arr[i] - upper;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            //该处条件是为了计算不出现偏差，若min = max 则之后计算会少计算min=max的个数，忽略了值本身
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans+=windowR-windowL;
        }

        long[] help = new long[R-L+1];
        int helpIndex = 0;
        int leftIndex = L;
        int rightIndex = M+1;
        while (leftIndex<=M && rightIndex<=R){
            help[helpIndex++] = arr[leftIndex]<=arr[rightIndex]?arr[leftIndex++]:arr[rightIndex++];
        }
        //左侧边界，左侧未跑完
        while (leftIndex <= M) {
            help[helpIndex++] = arr[leftIndex++];
        }
        //右侧边界，右侧未跑完
        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[L+i1] = help[i1];
        }
        return ans;
    }
}
