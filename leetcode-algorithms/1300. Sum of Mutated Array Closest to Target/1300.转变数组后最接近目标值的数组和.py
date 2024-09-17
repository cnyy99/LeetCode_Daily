#
# @lc app=leetcode.cn id=1300 lang=python3
#
# [1300] 转变数组后最接近目标值的数组和
#
# https://leetcode.cn/problems/sum-of-mutated-array-closest-to-target/description/
#
# algorithms
# Medium (46.92%)
# Likes:    209
# Dislikes: 0
# Total Accepted:    33.2K
# Total Submissions: 70.8K
# Testcase Example:  '[4,9,3]\n10'
#
# 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value
# 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
#
# 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
#
# 请注意，答案不一定是 arr 中的数字。
#
#
#
# 示例 1：
#
# 输入：arr = [4,9,3], target = 10
# 输出：3
# 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
#
#
# 示例 2：
#
# 输入：arr = [2,3,5], target = 10
# 输出：5
#
#
# 示例 3：
#
# 输入：arr = [60864,25176,27249,21296,20204], target = 56803
# 输出：11361
#
#
#
#
# 提示：
#
#
# 1 <= arr.length <= 10^4
# 1 <= arr[i], target <= 10^5
#
#
#


# @lc code=start
class Solution:
    # 题解参考 https://leetcode.cn/problems/sum-of-mutated-array-closest-to-target/solutions/101753/bian-shu-zu-hou-zui-jie-jin-mu-biao-zhi-de-shu-zu-
    def findBestValue(self, arr: List[int], target: int) -> int:
        # 先对arr进行排序
        arr.sort()
        length = len(arr)
        # 新建数据，保存arr[i]处的前缀和到prefix中
        prefix = [0]
        for num in arr:
            prefix.append(prefix[-1] + num)

        # 当arr整个数组的和都小于target时，直接返回arr的最大值，此时已经排序了，所以就是arr[-1]
        if prefix[-1] < target:
            return arr[-1]

        # 记录最终的结果和当前的差距
        ans, diff = 0, target

        # 遍历[1,arr[-1]]
        for i in range(1, arr[-1] + 1):
            # 插在i在arr中的位置，bisect_left选择左边的那个值
            index = bisect.bisect_left(arr, i)
            # 计算把index这个位置处后方全部替换为i时，数据的和
            sum = prefix[index] + (length - index) * i
            if abs(sum - target) < diff:
                # 如果鱼target的偏差更小，记录当前的i
                ans = i
                # 更新最小偏差
                diff = abs(sum - target)
        #返回结果
        return ans


# @lc code=end
