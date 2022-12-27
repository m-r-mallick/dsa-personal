/** Permutations */

import java.util.*;

class Permutations {
    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static List<Integer> getListFromArray(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }
    public static void solve(int[] arr, int index, List<List<Integer>> ans) {
        if (index >= arr.length) {
            ans.add(getListFromArray(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            solve(arr, index + 1, ans);
            swap(arr, index, i);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length > 0) {
            solve(nums, 0, ans);
        }
        return ans;
    }
	 public static void main(String[] args) {
		 int[] arr = {1, 2, 3, 4};
		 System.out.println(permute(arr));
	 }
}
