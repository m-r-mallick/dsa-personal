/** Given an array of size N containing N (unique + duplicate) integers, find all the unique subsets that add up to the given target sum, in sorted order */

import java.util.*;
public class CombinationSumII {
	public static void solve(int[] arr, int target, List<Integer> combination, List<List<Integer>> ans, int index) {
		if (target == 0) {
			ans.add(new ArrayList<>(combination));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			if (i > index && arr[i] == arr[i - 1]) continue;
			if (arr[i] > target) break;
			combination.add(arr[i]);
			solve(arr, target - arr[i], combination, ans, i + 1);
			combination.remove(combination.size() - 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {10, 2, 2, 5, 3, 3, 3, 8, 8, 19, 7, 6, 5};
		System.out.print("Enter target: ");
		int target = sc.nextInt();
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		Arrays.sort(arr);
		solve(arr, target, combination, ans, 0);
		System.out.println(ans);
		sc.close();
	}
}
