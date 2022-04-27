/*
 * @lc app=leetcode.cn id=946 lang=kotlin
 *
 * [946] 验证栈序列
 *
 * https://leetcode-cn.com/problems/validate-stack-sequences/description/
 *
 * algorithms
 * Medium (63.41%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    35K
 * Total Submissions: 55.2K
 * Testcase Example:  '[1,2,3,4,5]\n[4,5,3,2,1]'
 *
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop
 * 操作序列的结果时，返回 true；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed 的所有元素 互不相同
 * popped.length == pushed.length
 * popped 是 pushed 的一个排列
 * 
 * 
 */

// @lc code=start
class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        // 使用ArrayDeque代替Stack
        val stack = ArrayDeque<Int>()
        // 当前弹出元素的下标
        var poppedIndex = 0
        // 遍历入栈元素
        for (item in pushed) {
            // 入栈
            stack.push(item)
            while (stack.isNotEmpty() && stack.peek() == popped[poppedIndex]) {
                // 栈不为空且栈顶元素与当前要出栈的元素相同时
                // 出栈元素下标加一
                poppedIndex++
                // 出栈
                stack.pop()
            }
        }
        // 返回栈是否为空，为空时代表栈序列时合法的
        return stack.isEmpty()
    }
}

// @lc code=end

