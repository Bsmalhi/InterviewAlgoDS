package org.problems.leetcode.companies.meta;

class MergeSortedArray{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while(i >= 0){
            if(p2 < 0)
                break;
            if(p1 >= 0 && nums2[p2] > nums1[p1]){
                nums1[i--] = nums2[p2--];
            } else {
                nums1[i--] = nums1[p1--];
            }
        }
    }
    public static void main(String[] args) {
        MergeSortedArray merger = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merger.merge(nums1, m, nums2, n);
        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}