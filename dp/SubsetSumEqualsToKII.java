import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean memo(int[] arr, int index, int target, int[][] dp) {
        if (index == 0) return arr[index] == target;
        if (target == 0) return true;
        if (dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        boolean skip = memo(arr, index - 1, target, dp);
        boolean pick = false;
        if (arr[index] <= target) pick = memo(arr, index - 1, target - arr[index], dp);
        dp[index][target] = skip || pick ? 1 : 0;
        return skip || pick;
    }
    public static boolean tab(int[] arr, int size, int k, boolean[][] dp) {
        for (int i = 0; i < size; i++) dp[i][0] = true;
        if (arr[0] <= k) dp[0][arr[0]] = true;
        for (int index = 1; index < size; index++) {
            for (int target = 1; target <= k; target++) {
                boolean skip = dp[index - 1][target];
                boolean pick = false;
                if (arr[index] <= target) pick = dp[index - 1][target - arr[index]];
                dp[index][target] = skip || pick;
            }
        }
        return dp[size - 1][k];
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] idp = new int[n + 1][k + 1];
        boolean[][] bdp = new boolean[n + 1][k + 1];
        for (int[] row: idp) Arrays.fill(row, -1);
        for (boolean[] row: bdp) Arrays.fill(row, false);
        boolean memo_res = memo(arr, n - 1, k, idp);
        boolean tab_res = tab(arr, n, k, bdp);
        return memo_res || tab_res;
    }
}

