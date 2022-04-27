/*
 * @lc app=leetcode.cn id=102 lang=kotlin
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.65%)
 * Likes:    1295
 * Dislikes: 0
 * Total Accepted:    552.9K
 * Total Submissions: 854.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return mutableListOf()
        // 存放结果
        val result = mutableListOf<List<Int>>()
        // 队列
        val queue: Queue<TreeNode> = LinkedList()
        // 把根节点加入队列
        queue.add(root)
        while (queue.isNotEmpty()) {
            // 初始化存放这一层数据的list
            val list = mutableListOf<Int>()
            // 处理当前队列中的数据，是同一层的
            repeat(queue.size) {
                // 取出第一个数据
                val p = queue.poll()
                // 加入本层的list
                list.add(p.`val`)
                // 左子节点不为空时加入队列中，是下一层
                p.left?.let { queue.add(it) }
                // 右子节点不为空时加入队列中，是下一层
                p.right?.let { queue.add(it) }
            }
            // 本层加入result中
            result.add(list)
        }
        return result
    }
}
// @lc code=end

