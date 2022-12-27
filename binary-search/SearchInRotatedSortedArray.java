/** Search in Rotated Sorted Array */

/* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity. */

/** Examples */
/*
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
*/

/** Solution */

public class SearchInRotatedSortedArray {
    public static int pivot(int arr[]) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if (arr[start] < arr[end]) return start;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public static int binarySearch(int arr[], int lb, int ub, int key) {
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) {
                lb = mid + 1;
            }
            if (arr[mid] > key) {
                ub = mid - 1;
            }
        }
        return -1;
    }
    public static int search(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        int p = pivot(arr);
        int ans = -1;
        if (key == arr[p]) ans = p;
        if (key > arr[p] && key <= arr[end]) ans = binarySearch(arr, p + 1, end, key);
        if (key > arr[p] && key > arr[end]) ans = binarySearch(arr, start, p - 1, key);
        return ans;
    }
}
