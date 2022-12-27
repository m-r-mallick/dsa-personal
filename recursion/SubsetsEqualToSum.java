/** Print all subsets of an array whose sum is equal to the given target SUM */

import java.util.*;

public class SubsetsEqualToSum {
	public static void solve(int[] arr, int index, List<ArrayList<Integer>> ans, ArrayList<Integer> subset, int sumSoFar, int target) {
		if (index >= arr.length) {
			if (sumSoFar == target) {
				ans.add(subset);
			}
			return;
		}

		// exclude
		solve(arr, index + 1, ans, subset, sumSoFar, target);
		// include
		int newSumSoFar = sumSoFar + arr[index];
		ArrayList<Integer> temp = new ArrayList<>(subset);
		temp.add(arr[index]);
		solve(arr, index + 1, ans, temp, newSumSoFar, target);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> subset = new ArrayList<>();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		System.out.print("Enter target: ");
		int target = sc.nextInt();
		solve(arr, 0, ans, subset, 0, target);
		System.out.println(ans);
	}
}
