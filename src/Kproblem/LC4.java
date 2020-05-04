package Kproblem;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //todo:cc 偶数优化
        //even
        int len = nums1.length + nums2.length;
        if(len % 2 == 0){
            int median1 = helper(nums1, nums2, len / 2, 0, 0);
            int median2 = helper(nums1, nums2, len / 2 + 1, 0, 0);
            return (median1 + median2) / 2.0;
        }
        else{
            return helper(nums1, nums2, len / 2 + 1, 0, 0);
        }
    }

    private int helper(int[] nums1, int[] nums2, int k, int start1, int start2){
        if(start1 > nums1.length - 1){
            return nums2[start2 + k - 1];
        }
        if(start2 > nums2.length - 1)
            return nums1[start1 + k - 1];


        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int val1 = (start1 + k/2 - 1) < nums1.length ? nums1[start1 + k/2 -1] : Integer.MAX_VALUE;
        int val2 = (start2 + k/2 - 1) < nums2.length ? nums2[start2 + k/2 -1] : Integer.MAX_VALUE;

        if(val1 < val2)
            return helper(nums1, nums2, k - k/2, start1 + k/2, start2);
        else
            return helper(nums1, nums2, k - k/2, start1, start2 + k/2);
    }
}
