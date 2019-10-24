/*
 * @lc app=leetcode id=203 lang=cpp
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (35.89%)
 * Likes:    915
 * Dislikes: 57
 * Total Accepted:    241.4K
 * Total Submissions: 666.6K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
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
    ListNode *removeElements(ListNode *head, int val)
    {
        ListNode newHead = ListNode(-1);
        newHead.next = head;
        ListNode *p = &newHead;
        while (p->next)
        {
            if (p->next->val == val)
            {
                ListNode *temp = p->next;
                p->next = p->next->next;
                // delete temp;
            }
            else
            {
                p = p->next;
            }
        }
        return newHead.next;
    }
};
