/*
 * @lc app=leetcode id=107 lang=cpp
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
    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        queue<TreeNode *> thisLevel, nextLevel;
        if (root)
        {
            thisLevel.push(root);
        }
        vector<vector<int>> res;
        vector<int> one;
        while (!thisLevel.empty())
        {
            TreeNode *node = thisLevel.front();
            thisLevel.pop();
            one.push_back(node->val);
            if (node->left)
            {
                nextLevel.push(node->left);
            }
            if (node->right)
            {
                nextLevel.push(node->right);
            }
            if (thisLevel.empty())
            {
                thisLevel = nextLevel;
                res.push_back(one);
                one.clear();
                while (!nextLevel.empty())
                {
                    nextLevel.pop();
                }
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
// @lc code=end
