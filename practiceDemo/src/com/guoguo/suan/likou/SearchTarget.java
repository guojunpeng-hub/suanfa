package com.guoguo.suan.likou;

/**
 * @author xiaoguo
 * @date2022/1/9 0009 10:57
 */
public class SearchTarget {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            return 0;
        }
        int length = nums.length;
        int odd = length % 2;
        int index = 0;
        int mid = (length - 1) >> 1;
        if (odd == 1) {
            if (target == nums[0]) {
                return 0;
            }
            index++;
            mid++;
        }
        while (mid <= length - 1) {
            if (target == nums[index]) {
                return index;
            } else if (target == nums[mid]) {
                return mid;
            }
            index++;
            mid++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
