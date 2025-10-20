package org.problems.leetcode.arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int n: nums)
            total += n;
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            int rightSum = total - leftSum - nums[i];
            if(rightSum == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = pi.pivotIndex(nums);
        System.out.println("Pivot index: " + result); // Expected output: 3
    }

}
