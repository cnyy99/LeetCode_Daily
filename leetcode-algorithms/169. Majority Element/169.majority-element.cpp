/*
 * @lc app=leetcode id=169 lang=cpp
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (51.60%)
 * Total Accepted:    366.8K
 * Total Submissions: 704.1K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution
{
public:
    int majorityElement(vector<int> &nums)
    {
        // int max=0;
        // map<int,int>m,p;
        // for(auto it=nums.begin();it!=nums.end();it++)
        // {
        //     m[*it]++;
        //     //max=max>m[*it]?max:m[*it];
        //     if(max<m[*it])
        //     {
        //         max=m[*it];
        //         p[max]=*it;
        //     }
        // }
        // return p[max];
        sort(nums.begin(), nums.end());
        return nums[nums.size() / 2];
    }
};
