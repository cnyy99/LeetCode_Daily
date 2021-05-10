/*
 * @lc app=leetcode id=344 lang=kotlin
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (70.65%)
 * Likes:    2351
 * Dislikes: 772
 * Total Accepted:    1M
 * Total Submissions: 1.5M
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 * 
 * 
 * 
 * Follow up: Do not allocate extra space for another array. You must do this
 * by modifying the input array in-place with O(1) extra memory.
 * 
 */

// @lc code=start
class Solution {
    fun reverseString(s: CharArray): Unit {
        val length = s.size
        for (i in 0 until (length / 2)) {
            val ch = s[i]
            s[i] = s[length - i - 1]
            s[length - i - 1] = ch
        }
    }
}
// @lc code=end

