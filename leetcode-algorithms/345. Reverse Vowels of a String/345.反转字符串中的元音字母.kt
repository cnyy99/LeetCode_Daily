/*
 * @lc app=leetcode.cn id=345 lang=kotlin
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (54.02%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    117.6K
 * Total Submissions: 217.6K
 * Testcase Example:  '"hello"'
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "hello"
 * 输出："holle"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s 由 可打印的 ASCII 字符组成
 * 
 * 
 */

// @lc code=start
class Solution {
    // 元音字母的set
    val vowelSet = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    fun reverseVowels(s: String): String {
        // 左侧指针
        var left = 0
        // 右侧指针
        var right = s.length - 1
        // 用来移动字母的StringBuilder
        val new = StringBuilder(s)
        // 左右指针相遇为止
        while (left < right) {
            while (left < right && !(new[left] in vowelSet)) {
                // 跳过左侧非元音字母
                left++
            }
            while (left < right && !(new[right] in vowelSet)) {
                // 跳过右侧非元音字母
                right--
            }
            // 交换两侧的元音字母
            swap(new, left++, right--)
        }
        // 转换为字符串返回
        return new.toString()
    }

    private fun swap(s: StringBuilder, left: Int, right: Int) {
        val temp = s[right]
        s[right] = s[left]
        s[left] = temp
    }
}
// @lc code=end

