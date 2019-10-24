#
# @lc app=leetcode id=661 lang=python3
#
# [661] Image Smoother
#
# https://leetcode.com/problems/image-smoother/description/
#
# algorithms
# Easy (48.01%)
# Total Accepted:    33.7K
# Total Submissions: 69.5K
# Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
#
# Given a 2D integer matrix M representing the gray scale of an image, you need
# to design a smoother to make the gray scale of each cell becomes the average
# gray scale (rounding down) of all the 8 surrounding cells and itself.  If a
# cell has less than 8 surrounding cells, then use as many as you can.
#
# Example 1:
#
# Input:
# [[1,1,1],
# ⁠[1,0,1],
# ⁠[1,1,1]]
# Output:
# [[0, 0, 0],
# ⁠[0, 0, 0],
# ⁠[0, 0, 0]]
# Explanation:
# For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
# For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
# For the point (1,1): floor(8/9) = floor(0.88888889) = 0
#
#
#
# Note:
#
# The value in the given matrix is in the range of [0, 255].
# The length and width of the given matrix are in the range of [1, 150].
#
#
#
import math


class Solution:
    def imageSmoother(self, M: List[List[int]]) -> List[List[int]]:
        m = [{'a': 0, 'b': 0} for _ in range(9)]
        k = 0
        for i in range(-1, 2):
            for j in range(-1, 2):
                m[k]['a'] = i
                m[k]['b'] = j
                k += 1
        sol = [[0 for _ in range(len(M[0]))] for _ in range(len(M))]
        for i in range(len(M)):
            for j in range(len(M[0])):
                sum = 0
                count = 0
                for k in range(9):
                    newi = i+m[k]['a']
                    newj = j+m[k]['b']
                    if newi >= 0 and newi < len(M) and newj >= 0 and newj < len(M[0]):
                        sum += M[newi][newj]
                        count += 1
                if count != 0:
                    sol[i][j] = sum//count
        return sol

        # python 巧办法 https://leetcode.com/problems/image-smoother/discuss/272696/python
        # rows = len(M)

        # cols = len(M[0])

        # #print rows, cols

        # if rows > 150 or cols > 150:
        #     return None

        # #创造一个空的rows* cols的答案矩阵
        # result = [[0]* cols for _ in range(rows)]

        # #print result

        # #在原矩阵上围上一圈-1，这样每个元素都可以被周围9个（含自己）smooth

        # #顶上面铺上-1行
        # M.append([-1]*cols)

        # #底下面铺上-1行
        # M.insert(0,[-1]*cols)

        # for i in M:

        #     # 最右面铺上-1
        #     i.append(-1)

        #     # 最左边铺上-1
        #     i.insert(0,-1)

        # #创造一个像素容器
        # temp = []

        # for i in range(1,rows+1):

        #     for j in range(1,cols+1):

        #         # 添加8个方向的邻元素和自己
        #         temp.append(M[i+1][j])
        #         temp.append(M[i][j+1])
        #         temp.append(M[i-1][j])
        #         temp.append(M[i][j-1])
        #         temp.append(M[i+1][j+1])
        #         temp.append(M[i][j])
        #         temp.append(M[i+1][j-1])
        #         temp.append(M[i-1][j+1])
        #         temp.append(M[i-1][j-1])

        #         # 筛选出非-1的真实数据
        #         nums = [x for x in temp if x> -1]

        #         # 算出smooth值
        #         smooth = math.floor(sum(nums)/len(nums))

        #         # 给result矩阵加载该smooth值，注意一定要行，列都-1，因为M已经大了一圈
        #         result[i-1][j-1] = int(smooth)

        #         # 清空像素容器
        #         temp = []

        # return result
