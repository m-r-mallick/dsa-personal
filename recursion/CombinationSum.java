/** Given an integer array of size N consisting of only distinct, non-zero elements, find all the possible permutations of elements which add up to the given target */

import java.util.*;

public class CombinationSum {
	
	public static void solve(int[] arr, List<List<Integer>> ans, List<Integer> permutation, int target, int currentSum) { /** My Logic */
		if (currentSum >= target) {
			if (currentSum == target) {
				ans.add(permutation);
			}
			return;
		}

		for (int i: arr) {
			int newSum = currentSum + i;
			List<Integer> temp = new ArrayList<>(permutation);
			temp.add(i);
			solve(arr, ans, temp, target, newSum);
		}
	}

	public static void solveAgain(int[] arr, int index, List<List<Integer>> ans, List<Integer> permutation, int target) { /** Striver's Logic */
		if (index >= arr.length) {
			if (target == 0) {
				ans.add(permutation);
			}
			return;
		}
		
		int el = arr[index];
		List<Integer> temp = new ArrayList<>(permutation);
		if (el <= target) {
			temp.add(el);
			// repeat element
			solveAgain(arr, index, ans, temp, target - el);
			temp.remove(temp.size() - 1);
		}
		// next element
		solveAgain(arr, index + 1, ans, temp, target);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("Enter target: ");
		int target = sc.nextInt();
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		solve(arr, ans, permutation, target, 0);
		System.out.println("Mallick -> " + ans);
		ans.clear();
		permutation.clear();
		solveAgain(arr, 0, ans, permutation, target);
		System.out.println("Striver -> " + ans);
	}
}
