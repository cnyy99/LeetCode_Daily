/*
 * @lc app=leetcode id=485 lang=cpp
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (54.54%)
 * Total Accepted:    130.8K
 * Total Submissions: 238.8K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1:
 * 
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 * 
 * 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 */
class Solution
{
public:
    int findMaxConsecutiveOnes(vector<int> &nums)
    {
        int m = 0, max = 0;
        for (auto it = nums.begin(); it != nums.end(); it++)
        {
            if (*it == 1)
            {
                m++;
                max = max > m ? max : m;
            }
            else
            {
                m = 0;
            }
        }
        return max;
    }
};
