/*
 * @lc app=leetcode.cn id=20 lang=kotlin
 *
 * [20] 有效的括号
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.63%)
 * Likes:    3450
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.7M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "([)]"
 * 输出：false
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：s = "{[]}"
 * 输出：true
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由括号 '()[]{}' 组成
 * 
 * 
 */

// @lc code=start
class Solution {
    // 记录括号之间的对应关系
    private val mapping = mapOf(')' to '(', ']' to '[', '}' to '{')

    fun isValid(s: String): Boolean {
        // 初始化一个栈
        val q = ArrayDeque<Char>()
        // 遍历s中的字符
        for (c in s) {
            // 根据c来处理
            when (c) {
                // 如果是'}', ']', ')'，判断栈顶的元素是不是对应字母mapping[c]
                // 是的话，栈顶元素出栈
                // 否则，返回false
                '}', ']', ')' -> {
                    if (q.isNotEmpty() && q.last() == mapping[c]) {
                        q.removeLast()
                    } else {
                        return false
                    }
                }

                else -> q.addLast(c)
            }
        }
        // 返回q是不是为空
        return q.isEmpty()
    }
}
// @lc code=end

