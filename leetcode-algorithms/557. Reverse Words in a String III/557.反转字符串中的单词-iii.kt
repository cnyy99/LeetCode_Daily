/*
 * @lc app=leetcode.cn id=557 lang=kotlin
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (74.26%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    203.6K
 * Total Submissions: 274K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 * 
 * 
 */

// @lc code=start
class Solution {
        fun reverseWords(s: String): String {
        // 记录一个单词的起始下标位置
        var start = 0
        // java、kotlin重的String为不可变类型，所以必须转换为StringBuilder之后再进行处理
        val stringBuilder = StringBuilder(s)
        // 遍历整个字符串
        for (i in stringBuilder.indices) {
            if (stringBuilder[i] == ' ') {
                // 遇到空格之后表示遍历完了一个单词，开始翻转这一部分
                reverseWord(stringBuilder, start, i - 1)
                // 重置开始位置为-1
                start = -1
            } else if (start == -1 && stringBuilder[i] != ' ') {
                // 开始位置为-1且开始遇到第一个非空格字符，表示新的单词从该下标开始，记录当前位置
                start = i
            }
        }
        // 翻转最后一个单词
        reverseWord(stringBuilder, start, stringBuilder.lastIndex)
        return stringBuilder.toString()
    }

    // 反转字符串s中的s[left, right]部分
    private fun reverseWord(s: StringBuilder, left: Int, right: Int) {
        var l = left
        var r = right
        while (l < r) {
            s[l] = s[r].also { s[r] = s[l] }
            ++l
            --r
        }
    }

    // 递归处理单词，效率较低
    fun reverseWordsRecursive(s: String): String {
        if (s.isEmpty()) {
            return s
        }
        // 找到第一个非空格字符的位置（0或1）
        val index = if(s[0]==' ') 1 else 0
        // 找到第一个空格字符的位置，没有时返回字符串的长度
        val index2 = s.indexOf(' ', startIndex = index + 1).takeIf { it != -1 } ?: s.length
        // 结果为第一个单词翻转之后加上递归处理的剩下的部分
        return s.substring(0, index) + s.substring(index, index2).reversed() + reverseWordsRecursive(
            s.substring(
                index2,
                s.length
            )
        )
    }
}
// @lc code=end

