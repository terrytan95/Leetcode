import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (32.58%)
 * Total Accepted:    331.7K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list: lists){
            if (list != null){
                queue.add(list);
            }
        }

        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null){
                queue.add(cur.next);
            }
        }

        return dummy.next;
    }
}
