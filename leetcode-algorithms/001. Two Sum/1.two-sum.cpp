/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (42.22%)
 * Total Accepted:    1.6M
 * Total Submissions: 3.7M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 *
 *
 */
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        // vector<int>temp;
        // bool t=false;
        // for(int i=0;i<nums.size();i++)
        // {
        //     for(int j=0;j<nums.size();j++)
        //     {
        //         if(i!=j)
        //         {
        //             if(nums[i]+nums[j]==target)
        //             {
        //                 temp.push_back(i);
        //                 temp.push_back(j);
        //                 t=true;
        //                 break;
        //             }
        //         }
        //     }
        //     if(t)
        //         break;
        // }
        // return temp;
        map<int, int> a;
        vector<int> sol(2);
        for (int i = 0; i < nums.size(); i++)
        {
            if (a.find(target - nums[i]) != a.end())
            {
                sol[0] = a[target - nums[i]];
                sol[1] = i;
            }
            a[nums[i]] = i;
        }
        return sol;
    }
};
