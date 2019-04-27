/*
 * @lc app=leetcode id=16 lang=cpp
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.16%)
 * Total Accepted:    329.7K
 * Total Submissions: 739.4K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int closest=INT_MAX;
        int this_len=0;
        int sol;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++)
        {
            int left=i+1;
            int right=nums.size()-1;
            while(left<right)
            {
                int this_sum=nums[i]+nums[left]+nums[right];
                this_len=abs(this_sum-target);
                if(this_sum==target)
                {
                    return this_sum;
                }
                if(this_len<closest)
                {
                    closest=this_len;
                    sol=this_sum;
                }
                if(this_sum>target)
                {
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return sol;
    }
};

