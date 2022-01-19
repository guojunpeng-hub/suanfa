package com.guoguo.suan.likou;

import java.math.BigDecimal;

/**
 * @author xiaoguo
 * @date2022/1/12 0012 23:51
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = null;
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null || nums1.length == 0) {
            arr = nums2;
        } else if (nums2 == null || nums2.length == 0) {
            arr = nums1;
        } else {
            arr = mergeArray(nums1, nums2);
        }
        int num = arr.length % 2;
        if (num == 1) {
            return arr[arr.length / 2];
        }
        Double mid1 = new Double(arr[arr.length / 2]);
        Double mid2 = new Double(arr[arr.length / 2 - 1]);
        double shang = (mid1 + mid2) / 2;
        return shang;
    }

    public static int[] mergeArray(int[] nums1, int[] nums2) {
        int[] help = new int[nums1.length + nums2.length];
        int helpIndex = 0;
        int left = 0;
        int right = 0;
        while (left <= (nums1.length - 1) && right <= (nums2.length - 1)) {
            help[helpIndex++] = nums1[left] <= nums2[right] ? nums1[left++] : nums2[right++];
        }
        while (left <= (nums1.length - 1)) {
            help[helpIndex++] = nums1[left++];
        }
        while (right <= (nums2.length - 1)) {
            help[helpIndex++] = nums2[right++];
        }
        return help;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
