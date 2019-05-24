/*
 * @lc app=leetcode id=228 lang=cpp
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (35.27%)
 * Likes:    360
 * Dislikes: 359
 * Total Accepted:    130.5K
 * Total Submissions: 364K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 */
class Solution
{
public:
    vector<string> summaryRanges(vector<int> &nums)
    {
        vector<string> result;
        int length = nums.size();
        for (int i = 0; i < length; i++)
        {
            int pre = nums[i];
            while (i + 1 < length && nums[i + 1] == nums[i] + 1)
            {
                i++;
            }
            if (pre == nums[i])
            {
                result.push_back(to_string(pre));
            }
            else
            {
                result.push_back(to_string(pre) + "->" + to_string(nums[i]));
            }
        }
        return result;
    }
};
