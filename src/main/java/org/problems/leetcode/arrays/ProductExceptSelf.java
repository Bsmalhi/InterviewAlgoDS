package org.problems.leetcode.arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        int left = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = left; // 1, 1, 2, 8
            left *= nums[i]; // 1 * 1, 1 * 2, 2 * 4, 8
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= right; // 1 * 8, 2 * 6, 24 * 1, 48
            right *= nums[i]; // 1 * 6, 6 * 4, 24 * 2
        }
        return result;
    }
    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums = {1, 2, 4, 6};
        int[] result = pes.productExceptSelf(nums);
        System.out.print("Product except self: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Expected output: 48 24 12 8
    }
}
