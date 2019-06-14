#
# @lc app=leetcode id=111 lang=python3
#
# [111] Minimum Depth of Binary Tree
#
# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
#
# algorithms
# Easy (34.89%)
# Likes:    730
# Dislikes: 394
# Total Accepted:    298.5K
# Total Submissions: 844K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# Given a binary tree, find its minimum depth.
#
# The minimum depth is the number of nodes along the shortest path from the
# root node down to the nearest leaf node.
#
# Note: A leaf is a node with no children.
#
# Example:
#
# Given binary tree [3,9,20,null,null,15,7],
#
#
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
#
# return its minimum depth = 2.
#
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left, right = self.minDepth(root.left), self.minDepth(root.right)
        return 1 + (min(left, right) if min(left, right) != 0 else max(left, right))
