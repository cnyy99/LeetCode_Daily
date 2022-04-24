/*
 * @lc app=leetcode.cn id=155 lang=kotlin
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (58.02%)
 * Likes:    1280
 * Dislikes: 0
 * Total Accepted:    368.1K
 * Total Submissions: 634.4K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 实现 MinStack 类:
 * 
 * 
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10^4 次
 * 
 * 
 */

// @lc code=start
class MinStack() {
    //使用Pair<Int, Int>来记录<当前元素，到当前位置为止最小的元素>
    private val stack = Stack<Pair<Int, Int>>()
    fun push(x: Int) {
        if (stack.size == 0) {
            // stack 为空时，直接加入元素即可
            stack.push(x to x)
        } else {
            // stack不为空时， 需要与目前为止最小的元素进行比较
            val min = stack.peek().second
            // 得到新的最小元素
            val newMin = min.coerceAtMost(x)
            // 添加到新的
            stack.push(x to newMin)
        }
    }

    fun pop() {
        // 弹出一个元素
        stack.pop()
    }

    fun top(): Int {
        // 返回最上层元素的first（元素本身）
        return stack.peek().first
    }

    fun getMin(): Int {
        // 返回最上层元素的second（到该元素为止的最小值）
        return stack.peek().second
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
// @lc code=end

