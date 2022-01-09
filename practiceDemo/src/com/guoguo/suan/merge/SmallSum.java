package com.guoguo.suan.merge;

/**
 * @author xiaoguo
 * @Description 利用归并排序求最小和，什么事最小和
 *在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 *  例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * @date2022/1/2 0002 19:46
 */
public class SmallSum {

    public static int commonCompare(int[] arr){
        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0;  j < i; j++) {
                res+=arr[i]>arr[j]?arr[i]:0;
            }
        }

        return res;
    }

    /**
     * 迭代处理拆解后合并，以右比左，来计算和
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int process(int[] arr,int L,int R){
        //边界条件，防止重复循环
        if(L==R){
            return 0;
        }
        int mid = L+ ((R-L)>>1);
        return  process(arr,L,mid)+process(arr,mid+1,R)+merge(arr,L,mid,R);
    }

    public static int merge(int[] arr,int L,int M,int R){
        //协助数组
        int[] help = new int[R-L+1];
        //协助数组的索引
        int helpIndex = 0;
        //左侧比较起点
        int leftIndex = L;
        //右侧比较起点
        int rightIndex = M+1;
        // 求和暂存
        int res = 0;
        //左右数组进行比较强
        while (leftIndex<=M && rightIndex<=R){
            //(R-rightIndex+1)右侧一共有多少值大于当前左侧值，全部加起来为累计
            res+=arr[leftIndex]<=arr[rightIndex]?(R-rightIndex+1)*arr[leftIndex]:0;
            //左右数组比较，进行排序
            help[helpIndex++] = arr[leftIndex]<=arr[rightIndex]?arr[leftIndex++]:arr[rightIndex++];
        }
        //左侧数组未循环完，剩余放在最后
        for (int i = leftIndex; i <=M; i++) {
            help[helpIndex++] = arr[leftIndex];
        }
        //右侧数组未循环完，剩余放在最后
        for (int i = rightIndex; i <=R; i++) {
            help[helpIndex++] = arr[rightIndex];
        }

        //将排序号的协助数组放回原数组
        for (int i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
        return res;
    }

}
