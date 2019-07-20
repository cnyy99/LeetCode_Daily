/*
 * @lc app=leetcode id=912 lang=cpp
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (63.48%)
 * Likes:    58
 * Dislikes: 78
 * Total Accepted:    10.6K
 * Total Submissions: 16.7K
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 * 
 * 
 */
class Solution
{
public:
    vector<int> sortArray(vector<int> &nums)
    {
        vector<int> count(50000 + 50000 + 1, 0);
        for (auto t : nums)
        {
            count[t + 50000]++;
        }
        for (int i = 0, j = 0; i < count.size(); i++)
        {
            if (count[i]--)
            {
                nums[j++] = i - 50000;
            }
        }
        return nums;
    }
};
