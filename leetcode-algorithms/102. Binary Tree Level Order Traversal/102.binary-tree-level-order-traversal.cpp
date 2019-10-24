/*
 * @lc app=leetcode id=102 lang=cpp
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
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> res;
        if (!root)
        {
            return res;
        }
        queue<TreeNode *> myqueue;
        myqueue.push(root);
        myqueue.push(NULL);
        vector<int> cur_vector;
        while (!myqueue.empty())
        {
            TreeNode *t = myqueue.front();
            myqueue.pop();
            if (t)
            {
                cur_vector.push_back(t->val);
                if (t->left)
                {
                    myqueue.push(t->left);
                }
                if (t->right)
                {
                    myqueue.push(t->right);
                };
            }
            else
            {
                res.push_back(cur_vector);
                cur_vector.resize(0);
                if (myqueue.size() > 0)
                {
                    myqueue.push(NULL);
                }
            }
        }
        return res;
    }
};
