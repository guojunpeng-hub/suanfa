package com.guoguo.suan;

/**
 * @author xiaoguo
 * @date2022/1/15 0015 22:19
 */
public class HeapSort {
    /**
     * 堆插入的时候
     *
     * @param arr
     * @param index
     */
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆弹出时重整堆结构
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public void heapifly(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            //找到较大的坐标
            largest = arr[index] > arr[largest] ? index : largest;
            //相同就推出，找完了就是
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    /**
     * 利用堆结构排序
     * @param arr
     * @return
     */
    public int[] heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            heapifly(arr,i,arr.length);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapifly(arr,0,--size);
            swap(arr,0,--size);
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
