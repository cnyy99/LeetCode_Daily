/*
 * @lc app=leetcode id=258 lang=kotlin
 *
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (58.67%)
 * Likes:    1172
 * Dislikes: 1300
 * Total Accepted:    353.4K
 * Total Submissions: 600.8K
 * Testcase Example:  '38'
 *
 * Given an integer num, repeatedly add all its digits until the result has
 * only one digit, and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= num <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 */

// @lc code=start
class Solution {
    fun addDigits(num: Int): Int {
        if (num <= 9) {
            return num
        }
        val res = num % 9 
        return  if (res == 0) 9 else res 
    }
}
// @lc code=end

