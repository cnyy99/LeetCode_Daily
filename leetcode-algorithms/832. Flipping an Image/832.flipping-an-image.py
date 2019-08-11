#
# @lc app=leetcode id=832 lang=python3
#
# [832] Flipping an Image
#
# https://leetcode.com/problems/flipping-an-image/description/
#
# algorithms
# Easy (71.59%)
# Total Accepted:    87.7K
# Total Submissions: 121.4K
# Testcase Example:  '[[1,1,0],[1,0,1],[0,0,0]]'
#
# Given a binary matrix A, we want to flip the image horizontally, then invert
# it, and return the resulting image.
#
# To flip an image horizontally means that each row of the image is reversed.
# For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
#
# To invert an image means that each 0 is replaced by 1, and each 1 is replaced
# by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
#
# Example 1:
#
#
# Input: [[1,1,0],[1,0,1],[0,0,0]]
# Output: [[1,0,0],[0,1,0],[1,1,1]]
# Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
# Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
#
#
# Example 2:
#
#
# Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
# Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
# Explanation: First reverse each row:
# [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
# Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
#
#
# Notes:
#
#
# 1 <= A.length = A[0].length <= 20
# 0 <= A[i][j] <= 1
#
#
#


class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        # for t in A:
        #     t.reverse()
        #     for i in range(len(t)):
        #         if t[i]==0:
        #             t[i]=1;
        #         else:
        #             t[i]=0;
        # return A
        return [[1-i for i in row[::-1]] for row in A]
    '''
    return [[1-i for i in row[::-1]] for row in A]

    
    for row in A:
        for i in xrange((len(row) + 1) / 2):
                """
                In Python, the shortcut row[~i] = row[-i-1] = row[len(row) - 1 - i]
                helps us find the i-th value of the row, counting from the right.
                """
            row[i], row[~i] = row[~i] ^ 1, row[i] ^ 1
    
        b = 0
        d = []
        for alist in A:
            alist.reverse()
            c=[]
            for a in alist:

                b = 1-a

                c.append(b)
            print(c)
            d.append(c)
        return d
        '''
