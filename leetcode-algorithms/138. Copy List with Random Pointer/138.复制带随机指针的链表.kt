/*
 * @lc app=leetcode.cn id=138 lang=kotlin
 *
 * [138] 复制带随机指针的链表
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (66.89%)
 * Likes:    882
 * Dislikes: 0
 * Total Accepted:    148.2K
 * Total Submissions: 221.2K
 * Testcase Example:  '[[7,null],[13,0],[11,4],[10,2],[1,0]]'
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
 * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
 * --> y 。
 * 
 * 返回复制链表的头节点。
 * 
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * 
 * 
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 
 * 
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 1000
 * -10^4 <= Node.val <= 10^4
 * Node.random 为 null 或指向链表中的节点。
 * 
 * 
 */

// @lc code=start
/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        // node为null时直接返回
        node ?: return node
        // map记录旧节点于新节点的映射关系
        val map = hashMapOf<Node, Node>()
        // 记录旧的初始指针
        var old_p = node
        // 生成新的头部
        val newHead = Node(node.`val`)
        // 记录新的初始指针
        var new_p = newHead
        // 记录旧头部与新头部的映射关系
        map[node] = newHead
        while (old_p!!.next != null) {
            // 遍历下一个节点
            old_p = old_p!!.next
            // 生成新的下一个节点
            new_p.next = Node(old_p!!.`val`)
            // 新节点向后移动
            new_p = new_p.next!!
            // 记录
            map[old_p] = new_p
        }
        // 指针回到旧头部
        old_p = node
        // 指针回到新头部
        new_p = newHead
        // 赋值给新头部指针的random字段
        new_p.random = map[old_p.random]
        while (old_p!!.next != null) {
            //依次给后面的指针赋值random（依据map中记录的新旧映射关系）
            old_p = old_p!!.next
            new_p = new_p.next!!
            new_p.random = map[old_p!!.random]
        }
        // 返回新的头部指针
        return newHead
    }
}

// @lc code=end

