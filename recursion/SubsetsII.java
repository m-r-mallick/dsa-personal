/** Given an array of N integers (may contain duplicates) print all the non-duplicate subsets of the array */

import java.util.*;
public class SubsetsII {
	static void solve(int[] arr, int index, List<List<Integer>> ans, List<Integer> subset) {
		ans.add(new ArrayList<>(subset));
		for (int i = index; i < arr.length; i++) {
			if (i > index && arr[i] == arr[i - 1]) continue;
			subset.add(arr[i]);
			solve(arr, i + 1, ans, subset);
			subset.remove(subset.size() - 1);
		}
	}
	public static void main(String[] args) {
		int[] arr = {5, 4, 2, 4, 9, 2};
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		Arrays.sort(arr);
		solve(arr, 0, ans, subset);
		System.out.println(ans);
	}
}
