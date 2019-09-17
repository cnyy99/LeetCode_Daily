/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (36.50%)
 * Likes:    811
 * Dislikes: 84
 * Total Accepted:    53.2K
 * Total Submissions: 144.5K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[0,0,0]]
 * 
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 
 * 
 * Example 2: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,1,1]]
 * 
 * Output:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,2,1]]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j, 1);
                }
            }
        }
        return matrix;
    }

    private void dfs(int[][] matrix, int row, int col, int val) {
        if (row < 0 || col < 0 || col >= matrix[0].length || row >= matrix.length
                || (matrix[row][col] <= val && val != 1)) {
            return;
        }
        matrix[row][col] = val;

        dfs(matrix, row + 1, col, matrix[row][col] + 1);
        dfs(matrix, row - 1, col, matrix[row][col] + 1);
        dfs(matrix, row, col + 1, matrix[row][col] + 1);
        dfs(matrix, row, col - 1, matrix[row][col] + 1);
    }

    private boolean hasNeiberZero(int row, int col, int[][] matrix) {
        if (row > 0 && matrix[row - 1][col] == 0) {
            return true;
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] == 0) {
            return true;
        }
        if (col > 0 && matrix[row][col - 1] == 0) {
            return true;
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] == 0) {
            return true;
        }
        return false;
    }
}
