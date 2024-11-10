import java.util.*;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (45.53%)
 * Total Accepted:    340.4K
 * Total Submissions: 731.4K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, k - 1);
    }

    // Quick select
    private int select(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left == right)
                return nums[left];
            int pivotIndex = medianOf3(nums, left, right);
            pivotIndex = partition(nums, left, right, pivotIndex);
            if (pivotIndex == k)
                return nums[k];
            else if (pivotIndex > k)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
    }

    // Use median-of-three strategy to choose pivot
    private int medianOf3(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (nums[right] > nums[left])
            swap(nums, left, right);
        if (nums[right] > nums[mid])
            swap(nums, right, mid);
        if (nums[mid] > nums[left])
            swap(nums, left, mid);
        return mid;
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int index = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] > pivotValue) {
                swap(nums, index, i);
                ++index;
            }
        }
        swap(nums, right, index);
        return index;
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
