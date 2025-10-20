package org.problems.leetcode.companies.meta;

class Sqrt {
    // perform binary search from 2 to x/2 as we know sqrt(x) is always less than x / 2
    // also sqrt 0 or 1 is num itself
    public int findSqrt(int x){
        if(x < 2)
            return x;
        int left = 2, right = x/2;
        long num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if(num > x){
                right = mid - 1;
            } else if(num < x){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        int[] testCases = {0, 1, 4, 8, 9, 15, 16, 25, 100, 2147395599};
        int[] expected = {0, 1, 2, 2, 3, 3, 4, 5, 10, 46339};
        for (int i = 0; i < testCases.length; i++) {
            int result = sqrt.findSqrt(testCases[i]);
            System.out.print("Input: " + testCases[i] + ", Expected: " + expected[i] + ", Got: " + result);
            if (result == expected[i]) {
                System.out.println(" -> PASS");
            } else {
                System.out.println(" -> FAIL");
            }
        }
    }
}