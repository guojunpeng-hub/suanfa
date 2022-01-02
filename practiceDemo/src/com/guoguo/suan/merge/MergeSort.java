package com.guoguo.suan.merge;

import java.util.Arrays;

/**
 * @author ：gjp
 * @date ：Created in 2021/12/30 下午3:39
 * @description：归并排序练习
 * @modified By：
 * @version:
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        //临界条件，当R与L相当时不做操作
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    /**
     * 合并左右侧数组
     *
     * @param arr
     * @param L
     * @param M
     * @param R
     * @return
     */
    public static int[] merge(int[] arr, int L, int M, int R) {
        //协助数组，当前排序
        int[] help = new int[R - L + 1];
        //help的计数
        int helpIndex = 0;
        //左侧起始值
        int leftIndex = L;
        //右侧起始值
        int rightIndex = M + 1;
        //左右侧起始值比较，依次比较，最终左侧或者右侧一定会到达临界条件
        while (leftIndex <= M && rightIndex <= R) {
            help[helpIndex++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        //当右侧到达临界条件后，将左侧跑完
        while (leftIndex <= M) {
            help[helpIndex++] = arr[leftIndex++];
        }
        //当左侧到达临界条件后，将右侧跑完
        while (rightIndex <= R) {
            help[helpIndex++] = arr[rightIndex++];
        }
        //将排序好的help，依次放入arr数组
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return arr;
    }

    /**
     * 不迭代版本
     *
     * @param arr
     */
    public static void mergeSortV2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        //每次循环走多少步长
        int mergesize = 1;
        while (mergesize < length) {
            //起始开始值
            int L = 0;
            while (L < length) {
                if (mergesize >= length - L) {
                    break;
                }
                //每步跨多少数进行排序
                int M = L + mergesize - 1;
                // 最右侧到哪里，后侧防止跨出去；
                int R = M + Math.min(mergesize, length - M -1);
                merge(arr, L, M, R);
                //下一次从哪里开始
                L = R + 1;
            }
            if (mergesize > length / 2) {
                break;
            }
            mergesize = mergesize << 1;
        }
    }

    public  static int[] generateRandomArray(int length,int maxNum){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random(maxNum);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }


    public static int random(int maxNum){
        return (int)(Math.random()*maxNum +1) -(int)(Math.random()*maxNum +1);
    }

    public static void main(String[] args) {
        int times = 10000;
        int maxNum = 10;
        int length = 20;
        for (int i = 0; i < times; i++) {
            int[] array = generateRandomArray(length, maxNum);
            int[] copyArray = copyArray(array);
            mergeSort(array);
            mergeSortV2(copyArray);
            if(!isEqual(array,copyArray)){
                System.out.println("整错了吧，你瞅瞅！");
            }
        }
        System.out.println("测试完了");
    }
}