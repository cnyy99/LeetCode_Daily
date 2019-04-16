/*
 * @lc app=leetcode id=219 lang=cpp
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (34.74%)
 * Total Accepted:    190.8K
 * Total Submissions: 545K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int,int>sol;
        for(int i=0;i<nums.size();i++)
        {
            if(sol[nums[i]]&&abs(sol[nums[i]]-i-1)<=k)
                return true;
            sol[nums[i]]=i+1;
        }
        return false;
        // unordered_map<int,vector<int>>sol;
        // for(int i=0;i<nums.size();i++)
        // {
        //         if(sol[nums[i]].size()<2)
        //         {
        //             sol[nums[i]].push_back(i);
        //             if(sol[nums[i]].size()==2)
        //             {
        //                 sol[nums[i]].push_back(sol[nums[i]][1]-sol[nums[i]][0]);
        //                 if(sol[nums[i]][2]<=k)
        //                     return true;
        //             }
        //         }
        //         else
        //         {
        //             if(i-sol[nums[i]][1]<sol[nums[i]][2])
        //             {
        //                 sol[nums[i]][2]=i-sol[nums[i]][1];
        //             }
        //             sol[nums[i]][1]=i;
        //             if(sol[nums[i]][2]<=k)
        //                 return true;
        //         }
        // }
        // return false;
    }
};

