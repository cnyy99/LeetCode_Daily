/*
 * @lc app=leetcode.cn id=5 lang=kotlin
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (36.04%)
 * Likes:    4602
 * Dislikes: 0
 * Total Accepted:    849.8K
 * Total Submissions: 2.4M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "a"
 * 输出："a"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "ac"
 * 输出："a"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由数字和英文字母（大写和/或小写）组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""
        for (i in s.indices) {
            // 奇数最长的回文子串
            val r1 = isPalindrome(s, i, i)  
            // 偶数最长的回文子串
            val r2 = isPalindrome(s, i, i + 1)  
            if (r1 > result.length || r2 > result.length) {
                // result更新为最长的子串
                result = if (r1 > r2) {
                    s.substring(i - r1 / 2, i + r1 / 2 + 1) 
                } else {
                    s.substring(i - r2 / 2 + 1, i + r2 / 2 + 1) 
                }
            }
        }
        return result
    }

    // 判断字符串s是不是回文串
    private fun isPalindrome(s: String, l: Int, r: Int): Int {
        var left = l
        var right = r
        while (left >= 0 && right < s.length) {
            // 左右指针依次向外移动并比较，直到不同时break
            if (s[left] != s[right]) {
                break
            }
            --left
            ++right
        }
        // 返回该字串的长度
        return right - left - 1
    }
}
// @lc code=end

