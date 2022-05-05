/*
 * @lc app=leetcode.cn id=113 lang=kotlin
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (63.11%)
 * Likes:    739
 * Dislikes: 0
 * Total Accepted:    248.9K
 * Total Submissions: 394.3K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 
 * -1000 
 * 
 * 
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
    // 存储结果
    private val result = ArrayList<List<Int>>()
    // 目标
    private var target = 0

    fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
        // 空树直接返回空树组
        root ?: return listOf()
        // 设定目标
        this.target = target
        // 递归深度优先遍历
        path(root, 0, mutableListOf<Int>())
        return result
    }

    private fun path(root: TreeNode?, current: Int, list: MutableList<Int>) {
        // 节点为空时返回
        root ?: return
        // 计算到当前位置为止的和
        val sum = current + root.`val`
        // 将当前位置的值加入一次的结果list中
        list.add(root.`val`)
        if (sum == target && root.left == null && root.right == null) {
            // 这一条路径便利完且和sum与target相等时，代表是一个合法的结果
            // 加入result中
            result.add(list)
            return
        }
        // 递归遍历左子树
        path(root.left, sum, list.copyOf())
        // 递归遍历右子树
        path(root.right, sum, list.copyOf())
    }
    
    // 辅助方法，复制一个数组
    private fun <T> List<T>.copyOf(): MutableList<T> {
        return mutableListOf<T>().also { it.addAll(this) }
    }
}
// @lc code=end

