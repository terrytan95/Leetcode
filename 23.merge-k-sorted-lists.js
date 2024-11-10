/*
 * @lc app=leetcode id=23 lang=javascript
 *
 * [23] Merge k Sorted Lists
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */

var mergeKLists = function(lists) {
	if (lists.length === 0) {
		return null;
	}

	while (lists.length > 1) {
		let a = lists.shift();
		let b = lists.shift();
		const h = mergeLists(a, b);
		lists.push(h);
	}
	return lists[0];
};

var mergeLists = (l1, l2) => {
	const dummy = new ListNode(0);
	let temp = dummy;
	while (l1 && l2) {
		if (l1.val < l2.val) {
			temp.next = l1;
			l1 = l1.next;
		} else {
			temp.next = l2;
			l2 = l2.next;
		}
		temp = temp.next;
	}
	if (l1) {
		temp.next = l1;
	}
	if (l2) {
		temp.next = l2;
	}
	return dummy.next;
};
