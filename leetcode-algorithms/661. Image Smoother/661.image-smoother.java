/*
 * @lc app=leetcode id=661 lang=java
 *
 * [661] Image Smoother
 *
 * https://leetcode.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (48.01%)
 * Total Accepted:    33.7K
 * Total Submissions: 69.5K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you
 * need to design a smoother to make the gray scale of each cell becomes the
 * average gray scale (rounding down) of all the 8 surrounding cells and
 * itself.  If a cell has less than 8 surrounding cells, then use as many as
 * you can.
 * 
 * Example 1:
 * 
 * Input:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * Output:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * 
 * 
 * 
 * Note:
 * 
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 * 
 * 
 */
class Solution {
    class dir {
        public int a, b;
    }

    public int[][] imageSmoother(int[][] M) {
        dir m[] = new dir[9];
        for (int i = -1, k = 0; i < 2; i++) {
            for (int j = -1; j < 2; j++, k++) {
                dir temp = new dir();
                temp.a = i;
                temp.b = j;
                m[k] = temp;
            }
        }
        int[][] sol = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0, count = 0;
                for (int k = 0; k < 9; k++) {
                    int newi = i + m[k].a;
                    int newj = j + m[k].b;
                    if (newi >= 0 && newi < M.length && newj >= 0 && newj < M[0].length) {
                        sum += M[newi][newj];
                        count++;
                    }
                }
                if (count != 0)
                    sol[i][j] = sum / count;
            }
        }
        return sol;
    }
}
