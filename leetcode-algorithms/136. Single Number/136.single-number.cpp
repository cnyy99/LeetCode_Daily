/*
 * @lc app=leetcode id=136 lang=cpp
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (60.39%)
 * Likes:    2505
 * Dislikes: 93
 * Total Accepted:    473.3K
 * Total Submissions: 783.8K
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 * 
 */
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res = nums[0];
        for (int i = 1; i < nums.size();i++)
        {
            res ^= nums[i];
        }
        return res;
    }
};