package org.problems.leetcode.companies.meta;

class PlusOne{
    public int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            if(sum > 9){
                digits[i] = sum % 10;
                newDigits[i + 1] = digits[i];
                carry = sum / 10;
            } else {
                digits[i] = sum;
                newDigits = digits;
                carry = 0;
            }
        }
        if(carry == 1){
            newDigits[0] = carry;
            return newDigits;
        }
        return digits;
    }
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[][] testCases = {
            {1, 2, 3},
            {9, 9, 9},
            {0},
            {4, 3, 2, 1}
        };
        for (int[] digits : testCases) {
            int[] result = plusOne.plusOne(digits.clone());
            System.out.print("Input: ");
            for (int d : digits) System.out.print(d + " ");
            System.out.print("=> Output: ");
            for (int r : result) System.out.print(r + " ");
            System.out.println();
        }
    }
}