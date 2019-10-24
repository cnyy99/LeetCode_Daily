/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (51.15%)
 * Total Accepted:    354K
 * Total Submissions: 677.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution
{
public:
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> sol;
        vector<int> temp;
        sol.push_back(temp);
        for (auto t : nums)
        {
            int size = sol.size();
            for (int i = 0; i < size; i++)
            {
                vector<int> subsets(sol[i]);
                subsets.push_back(t);
                sol.push_back(subsets);
            }
        }
        return sol;
    }
};
