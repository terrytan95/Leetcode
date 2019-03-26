/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (52.18%)
 * Total Accepted:    501.9K
 * Total Submissions: 960.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */

// public class ListNode { 
//     int val; 
//     ListNode next; 
//     ListNode(int x) { val = x; } 
// }

class Solution {
    //iterative
    // public ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     while (curr != null) {
    //         ListNode nextTemp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = nextTemp;
    //     }
    //     return prev;
    // }

    //recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
