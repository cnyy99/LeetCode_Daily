/*
 * @lc app=leetcode id=461 lang=kotlin
 *
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (73.25%)
 * Likes:    2204
 * Dislikes: 178
 * Total Accepted:    397K
 * Total Submissions: 541.4K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 3, y = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x, y <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var result = x xor y
        var distance = 0
        while(result != 0)
        {
            result = result and (result -1)
            distance++
        }
        return distance
    }
}
// @lc code=end

