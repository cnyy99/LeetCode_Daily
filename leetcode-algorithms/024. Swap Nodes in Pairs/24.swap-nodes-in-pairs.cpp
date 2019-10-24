/*
 * @lc app=leetcode id=24 lang=cpp
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (44.99%)
 * Likes:    1303
 * Dislikes: 115
 * Total Accepted:    341.3K
 * Total Submissions: 745.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    ListNode *swapPairs(ListNode *head)
    {
        if (!head)
        {
            return head;
        }
        ListNode newHead = ListNode(-1);
        newHead.next = head;
        ListNode *p = &newHead, *q = head, *r = head->next;
        while (r)
        {
            swapNode(p, q, r);
            swap(r, q);
            p = p->next->next;
            q = q->next->next;
            if (!r->next)
            {
                break;
            }
            r = r->next->next;
        }
        return newHead.next;
    }

    void swapNode(ListNode *p, ListNode *q, ListNode *r)
    {
        q->next = r->next;
        r->next = q;
        p->next = r;
    }
};
