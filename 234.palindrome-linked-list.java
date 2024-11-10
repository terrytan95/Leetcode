/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.55%)
 * Total Accepted:    244K
 * Total Submissions: 684.7K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

import java.util.*;

class Solution {

    public boolean isPalindrome(ListNode head) {
        // edge case
        if (head == null || head.next == null)
            return true;
        ListNode mid = head.next, tail = head, pre = head;
        while (tail.next != null && tail.next.next != null) {
            tail = tail.next.next;
            head = mid;
            mid = mid.next;
            head.next = pre;
            pre = head;
        }
        if (tail.next == null)
            head = head.next;
        while (mid != null) {
            if (head.val == mid.val) {
                head = head.next;
                mid = mid.next;
            } else {
                return false;
            }
        }
        return true;

    }
}
