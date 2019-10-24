/*
 * @lc app=leetcode id=661 lang=cpp
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
class Solution
{
public:
    vector<vector<int>> imageSmoother(vector<vector<int>> &M)
    {
        struct dir
        {
            int a, b;
        };
        dir m[9];
        for (int i = -1, k = 0; i < 2; i++)
        {
            for (int j = -1; j < 2; j++, k++)
            {
                m[k].a = i;
                m[k].b = j;
            }
        }
        vector<vector<int>> sol(M.size(), vector<int>(M[0].size()));
        for (auto i = 0; i < M.size(); i++)
        {
            for (auto j = 0; j < M[0].size(); j++)
            {
                int sum = 0, count = 0;
                for (int k = 0; k < 9; k++)
                {
                    int newi = i + m[k].a;
                    int newj = j + m[k].b;
                    if (newi >= 0 && newi < M.size() && newj >= 0 && newj < M[0].size())
                    {
                        sum += M[newi][newj];
                        count++;
                    }
                }
                if (count)
                    sol[i][j] = sum / count;
            }
        }
        return sol;
    }
};
