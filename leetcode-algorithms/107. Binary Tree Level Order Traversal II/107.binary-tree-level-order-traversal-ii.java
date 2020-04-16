/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (48.66%)
 * Likes:    1105
 * Dislikes: 201
 * Total Accepted:    289.3K
 * Total Submissions: 572.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> thisLevel = new LinkedList<>();
        if (root != null) {
            thisLevel.offer(root);
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        while (!thisLevel.isEmpty()) {
            List<Integer> one = new LinkedList<>();
            int size = thisLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = thisLevel.poll();
                one.add(n.val);
                if (n.left != null) {
                    thisLevel.offer(n.left);
                }
                if (n.right != null) {
                    thisLevel.offer(n.right);
                }
            }
            res.addFirst(one);
        }
        return res;
    }
}
// @lc code=end

