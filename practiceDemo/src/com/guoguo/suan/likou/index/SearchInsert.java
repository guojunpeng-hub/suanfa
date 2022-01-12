package com.guoguo.suan.likou.index;

/**
 * @author xiaoguo
 * @date2022/1/9 0009 23:04
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid =left + ((right-left)>>1);
            int num = nums[mid];
            if(num>target){
                right = mid;
            }else if(num<target) {
                left = mid+1;
            }else {
                return mid;
            }
        }
        int index = 0;
        int helpIndex = 0;
        while (index<nums.length && helpIndex<(nums.length+1)){
            int num = nums[index];
            if(num<target){
                index++;
                helpIndex++;
            }else {
                break;
            }
        }
        return helpIndex;
    }

    public static void main(String[] args) {
        int[] nums = new  int[]{1,3,5,6};
        System.out.println(searchInsert(nums,5));
    }
}
