package org.problems.leetcode.arrays;

public class RangeSumQuery2D {

    private int[][] matrixSum;
    public RangeSumQuery2D(int[][] matrix) {
        matrixSum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int r = 0; r < matrix.length; r++){
            int prefix = 0; // to calculate row
            for(int c = 0; c < matrix[0].length; c++){
                prefix += matrix[r][c];
                int above = matrixSum[r][c + 1]; // current is actually above
                matrixSum[r + 1][c + 1] = prefix + above; // then we push new value r + 1 & c + 1
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // we are incrementing as we added a new row & col to matrixSum
        row1++; col1++; row2++; col2++;
        int bottomRight = matrixSum[row2][col2];
        int topRight = matrixSum[row1 - 1][col2]; // just above row1 we have top and right col
        int topLeft = matrixSum[row1 - 1][col1 - 1];
        int left = matrixSum[row2][col1 -1];
        return bottomRight - topRight - left + topLeft;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        RangeSumQuery2D rsq = new RangeSumQuery2D(matrix);
        int result = rsq.sumRegion(2, 1, 4, 3); // Expected: 8
        System.out.println("Sum of region (2,1) to (4,3): " + result);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

