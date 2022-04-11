/*
 * @lc app=leetcode.cn id=21 lang=kotlin
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.68%)
 * Likes:    2318
 * Dislikes: 0
 * Total Accepted:    947.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 两个链表的节点数目范围是 [0, 50]
 * -100 
 * l1 和 l2 均按 非递减顺序 排列
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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // return mergeTwoListsRecursive(list1,list2)
        
        // 发现null直接返回
        if (list2 == null) {
            return list1
        }
        // 发现null直接返回
        if (list1 == null) {
            return list2
        }
        // 新变量指向两个list
        var p1 = list1
        var p2 = list2
        // 结果指针为两个list中值较小的，指向之后位置要后移
        val result = if (p1.`val` > p2.`val`) p2.apply { p2 = p2!!.next } else p1.apply { p1 = p1!!.next }
        // 新list的指针
        var cur = result
        // 两个list均不为null时进行遍历
        while (p1 != null && p2 != null) {
            // 找到较小的值
            if (p1!!.`val` > p2!!.`val`) {
                // 添加到当前的位置
                cur.next = p2
                // p2后移
                p2 = p2!!.next
            } else {
                // 添加到当前的位置
                cur.next = p1
                // p1后移
                p1 = p1!!.next
            }
            // 当前位置后移
            cur = cur.next!!
        }
        // p1、p2中剩余的元素直接添加到cur后面
        cur.next = p1 ?: p2
        return result
    }
    fun mergeTwoListsRecursive(list1: ListNode?, list2: ListNode?): ListNode? {
        // 发现null直接返回
        if (list2 == null) {
            return list1
        }
        // 发现null直接返回
        if (list1 == null) {
            return list2
        }
        // 新变量指向两个list
        var p1 = list1
        var p2 = list2
        // 结果指针为两个list中值较小的，指向之后位置要后移
        val result = if (p1.`val` > p2.`val`) p2.apply { p2 = p2!!.next } else p1.apply { p1 = p1!!.next }
        // result.next 为递归处理剩下部分的结果
        result.next = mergeTwoListsRecursive(p1, p2)
        return result
    }
}
// @lc code=end

