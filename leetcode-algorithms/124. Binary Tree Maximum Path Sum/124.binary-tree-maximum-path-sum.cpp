/*
 * @lc app=leetcode id=124 lang=cpp
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (31.32%)
 * Likes:    2839
 * Dislikes: 240
 * Total Accepted:    294.1K
 * Total Submissions: 900.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    int res = INT_MIN;
    int maxPathSum(TreeNode *root)
    {
        pathCalc(root);
        return res;
    }
    int pathCalc(TreeNode *root)
    {
        if (!root)
        {
            return 0;
        }
        int left = max(pathCalc(root->left), 0);
        int right = max(pathCalc(root->right), 0);
        res = max(res, left + right + root->val);
        return max(left, right) + root->val;
    }
};
// @lc code=end
