import java.util.* ;
import java.io.*; 
public class SubsetSumEqualsToK {
    public static boolean solve(int[] arr, int len, int index, int target, int[][] dp) {
        if (target == 0) return true;
        if (index == len) return false;
        if (dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        boolean skip = solve(arr, len, index + 1, target, dp);
        boolean pick = false;
        if (arr[index] <= target) pick = solve(arr, len, index + 1, target - arr[index], dp);
        dp[index][target] = skip || pick ? 1 : 0;
        return skip || pick;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
        boolean answer = solve(arr, n, 0, k, dp);
		  for (int i = 0; i < dp.length; i++) {
			   System.out.println();
            for (int j = 0; j < dp[i].length; j++)
                System.out.print(dp[i][j] == -1 ? "×  " : dp[i][j] + "  ");
		  }
		  System.out.println();
		  return answer;
    }
	 public static void main(String[] args) {
		  int[] arr = {1, 2, 3, 4};
		  System.out.println(subsetSumToK(arr.length, 5, arr));
	 }
}

