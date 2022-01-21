/*
 * @lc app=leetcode.cn id=2 lang=kotlin
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (41.23%)
 * Likes:    7385
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.8M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(ll1: ListNode?, ll2: ListNode?): ListNode? {
        var up = 0
        var usel1 = true
        var res = ll1
        var l1: ListNode? = ll1
        var l2: ListNode? = ll2
        var l1r: ListNode? = ll1
        var l2r: ListNode? = ll2
        while (l1 != null || l2 != null) {
            val l1val = l1?.`val` ?: 0
            val l2val = l2?.`val` ?: 0
            var value = l1val + l2val + up
            if (value >= 10) {
                up = 1
                value = value % 10
            } else {
                up = 0
            }
            l1?.let {
                it.`val` = value
                l1r = it
                l1 = it.next
                usel1 = true
            }
            l2?.let {
                it.`val` = value
                l2r = it
                l2 = it.next
                usel1 = false
            }
        }
        var r = l1r
        if (!usel1) {
            res = ll2
            r = l2r
        }
        if (up == 1) {
            val node = ListNode(1)
            r!!.next = node
        }
        return res
    }
}
// @lc code=end

