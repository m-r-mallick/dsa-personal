import java.util.*;
public class SubsetsWithoutAdjacentElements {
	public static void getSubsets(int[] arr, int index, List<Integer> subset, List<List<Integer>> ans) {
		if (index >= arr.length) {
			ans.add(subset);
			return;
		}
		// don't pick
		getSubsets(arr, index + 1, subset, ans);
		// pick
		List<Integer> temp = new ArrayList<>(subset);
		temp.add(arr[index]);
		getSubsets(arr, index + 2, temp, ans);
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		getSubsets(arr, 0, subset, ans);
		System.out.println(ans);
	}
}
