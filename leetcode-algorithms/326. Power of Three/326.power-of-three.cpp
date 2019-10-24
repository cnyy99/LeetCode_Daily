/*
 * @lc app=leetcode id=326 lang=cpp
 *
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (41.79%)
 * Likes:    324
 * Dislikes: 1152
 * Total Accepted:    202.2K
 * Total Submissions: 483.3K
 * Testcase Example:  '27'
 *
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Example 1:
 * 
 * 
 * Input: 27
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: true
 * 
 * Example 4:
 * 
 * 
 * Input: 45
 * Output: false
 * 
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
class Solution
{
public:
    bool isPowerOfThree(int n)
    {
        return n > 0 && (int)pow(3, (int)(log10(INT_MAX) / log10(3))) % n == 0;
        // return fmod(log10(n) / log10(3),1) == 0.0;
    }
};
