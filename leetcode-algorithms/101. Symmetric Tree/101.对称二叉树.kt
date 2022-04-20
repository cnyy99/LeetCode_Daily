/*
 * @lc app=leetcode.cn id=101 lang=kotlin
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (57.49%)
 * Likes:    1869
 * Dislikes: 0
 * Total Accepted:    566.1K
 * Total Submissions: 984.6K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
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
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true
        // 返回左右子树是否轴对称
        return isSymmetricHelper(root.left, root.right)
    }
    
    //辅助方法
    private fun isSymmetricHelper(left: TreeNode?, right: TreeNode?): Boolean {
        // 都为空时返回true
        if (left == null && right == null) {
            return true
        }
        if (left?.`val` == right?.`val`) {
            // 递归判断剩下的部分，因为是轴对称，所以判断 
            // left.left 与 right.right相同，
            // left.right 与 right.left相同
            return isSymmetricHelper(left?.left, right?.right) &&
                isSymmetricHelper(left?.right, right?.left)
        }
        // left，right有一个为空或值不相等时返回false
        return false
    }
}

// @lc code=end

