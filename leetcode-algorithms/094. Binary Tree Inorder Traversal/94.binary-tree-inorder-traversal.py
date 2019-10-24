#
# @lc app=leetcode id=94 lang=python3
#
# [94] Binary Tree Inorder Traversal
#
# https://leetcode.com/problems/binary-tree-inorder-traversal/description/
#
# algorithms
# Medium (56.97%)
# Likes:    1673
# Dislikes: 72
# Total Accepted:    475.2K
# Total Submissions: 832.7K
# Testcase Example:  '[1,null,2,3]'
#
# Given a binary tree, return the inorder traversal of its nodes' values.
#
# Example:
#
#
# Input: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
#
# Output: [1,3,2]
#
# Follow up: Recursive solution is trivial, could you do it iteratively?
#
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        st, res2, p = [], [], root
        while p or st:
            while p:
                st.append(p)
                p = p.left
            p = st[-1]
            del st[-1]
            res2.append(p.val)
            p = p.right
        # res=[]
        # def inorder(root,res):
        #     if not root:
        #         return
        #     inorder(root.left, res)
        #     res.append(root.val)
        #     inorder(root.right, res)
        # inorder(root,res)
        # return res
        return res2
