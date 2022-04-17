/*
 * @lc app=leetcode.cn id=226 lang=kotlin
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (79.08%)
 * Likes:    1249
 * Dislikes: 0
 * Total Accepted:    429.6K
 * Total Submissions: 543.2K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
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
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
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
    fun invertTree(root: TreeNode?): TreeNode? {
        // one line solution
        // 后序遍历，先交换最底层的节点，先左子树，然后右子树，最终是当前节点
        return root?.also {
            root.right = invertTree(root.left).also { root.left = invertTree(root.right) }
        }
        // root ?: return root
        // 前序遍历，先交换最当前节点，然后左子树，最后右子树
        // root.right = root.left.also { root.left = root.right }
        // invertTree(root.left)
        // invertTree(root.right)
        // return root
    }
}
// @lc code=end

