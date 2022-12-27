import java.util.*;
public class MaxSubsetsSumWithoutAdjacentElements {
	public static int solve(int[] arr, int index, int[] dp) {
		if (index < 0) return 0;
		if (index == 0) return arr[index];

		if (dp[index] != -1) return dp[index];
		int pick = arr[index] + solve(arr, index - 2, dp);
		int notPick = 0 + solve(arr, index - 1, dp);

		return dp[index] = Math.max(pick, notPick);
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(solve(arr, arr.length - 1, dp));
	}
}
