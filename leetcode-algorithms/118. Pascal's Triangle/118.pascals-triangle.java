/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (44.68%)
 * Total Accepted:    241.2K
 * Total Submissions: 532.3K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        Integer[][] map = new Integer[numRows][];
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>(); // 初始化二维数组
        for (int i = 0; i < numRows; i++) // 初始化二维数组的每一行
        {
            map[i] = new Integer[i + 1];
            // map[i] = new int[i + 1];
            map[i][0] = map[i][i] = 1; // 每一行的开头和末尾置1
        }
        for (int i = 2; i < numRows; i++) // 从第三行开始
        {
            for (int j = 1; j < i; j++) // 对于这一行中的第二个到倒数第二个数
            {
                map[i][j] = (map[i - 1][j] + map[i - 1][j - 1]); // 每一个数位上一行上一列于这一列的和模10
            }
        }
        for (int i = 0; i < numRows; i++) {
            sol.add(Arrays.asList(map[i]));
        }
        return sol;
    }
}
