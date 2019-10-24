/*
 * @lc app=leetcode id=268 lang=cpp
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (47.59%)
 * Total Accepted:    262.3K
 * Total Submissions: 546.8K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
class Solution
{
public:
    int missingNumber(vector<int> &nums)
    {
        int sol = nums.size();
        for (int i = 0; i < nums.size(); i++)
        {
            sol ^= nums[i];
            sol ^= i;
        }
        return sol;
        // unordered_map<int,int>mp;
        // for (int i =0;i<nums.size();i++)
        // {
        //     mp[nums[i]]++;
        // }
        // for(int i=0;i<nums.size()+1;i++)
        // {
        //     if(mp[i]==0)
        //         return i;
        // }
        // return 0;
    }
};
