/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (48.80%)
 * Likes:    1532
 * Dislikes: 40
 * Total Accepted:    389.6K
 * Total Submissions: 796.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> myqueue = new ArrayDeque<>();
        myqueue.offer(root);
        TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);
        myqueue.offer(nullNode);
        List<Integer> cur_vector = new ArrayList<>();
        while (!myqueue.isEmpty()) {
            TreeNode t = myqueue.peekFirst();
            myqueue.pop();
            if (t.val != Integer.MIN_VALUE) {
                cur_vector.add(t.val);
                if (t.left != null) {
                    myqueue.offer(t.left);
                }
                if (t.right != null) {
                    myqueue.offer(t.right);
                }
                ;
            } else {
                res.add(cur_vector);
                cur_vector = new ArrayList<>();
                if (myqueue.size() > 0) {
                    myqueue.offer(nullNode);
                }
            }
        }
        return res;
        // dfs(root, res, 0);
        // return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}
