package org.problems.leetcode.companies.meta;

class ClimbingStairs {
    public int numOfWaysCimbStairs(int n){
        if(n <= 2){
            return n;
        }
        return numOfWaysCimbStairs(n - 1) + numOfWaysCimbStairs(n - 2);
    }
    public int numOfWaysCimbStairsWithMemo(int n){
        int [] memo = new int[n];
        return numOfWaysCimbStairsWithMemo(n, memo);
    }

    private int numOfWaysCimbStairsWithMemo(int n, int[] memo) {
        if(n <= 2){
            return n;
        }
        if(memo[n - 1] > 0)
            return memo[n - 1];
        memo[n - 1] = numOfWaysCimbStairsWithMemo(n - 1) + numOfWaysCimbStairsWithMemo(n - 2);
        return memo[n - 1];
    }

    /*
    This problem only uses 2 poiners to track recent 2 steps and build solution on that
    */
    public int climbingStairsDP(int n){
        int one = 1, two = 1;
        for(int i = 0; i < n - 1; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int[] testCases = {0, 1, 2, 3, 4, 5};
        for (int n : testCases) {
            System.out.println("n = " + n + ", Ways = " + cs.climbingStairsDP(n));
        }
    }
}