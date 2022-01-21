/*
 * @lc app=leetcode.cn id=3 lang=kotlin
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (38.38%)
 * Likes:    6785
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: s = ""
 * 输出: 0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxCount: Int = 0
        val set = HashSet<Char>()
        val map = HashMap<Char, Int>()
        var left = 0
        s.forEachIndexed { end, char ->
            if (char in set) {
                left = Math.max(map[char]!! + 1, left)
                set.remove(char)
            }
            maxCount = Math.max(maxCount, end - left + 1)
            set.add(char)
            map[char] = end
        }
        return maxCount
    }

    fun lengthOfLongestSubstringOld(s: String): Int {
        val set = HashSet<Char>()
        var count:Int = 0
        var maxCount:Int = 0
        val map = HashMap<Char, Int>()
        var i = 0
        while(i < s.length) {
            if (s[i] in set) {
                maxCount = Math.max(maxCount, count)
                set.clear()
                count = 0
                i = map[s[i]]!!
            } else {
                map[s[i]]=i
                count++
                set.add(s[i])
            }
            i++
        }
        return Math.max(maxCount, count)
    }
}
// @lc code=end

