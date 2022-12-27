import java.util.* ;
import java.io.*; 

public class Knapsack01 {
    public static int solveMemo(int[] weight, int[] value, int index, int remWeight, int[][] dp) {
        if (remWeight == 0) return 0;
        if (index < 0) return 0;
        if (dp[index][remWeight] != -1) return dp[index][remWeight];
        
        int skip = solve(weight, value, index - 1, remWeight, dp);
        int pick = 0;
        if (weight[index] <= remWeight) pick = value[index] + solve(weight, value, index - 1, remWeight - weight[index], dp);
        return dp[index][remWeight] = Math.max(pick, skip);
    }
    static int solveTab(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int i = 0; i < n; i++) dp[i][0] = 0;
        for (int index = 0; index < n; index++) {
            for (int remWeight = 1; remWeight <= maxWeight; remWeight++) {
                if (index == 0) {
                    int skip = 0;
                    int pick = 0;
                    if (weight[index] <= remWeight) pick = value[index] + 0;
                    dp[index][remWeight] = Math.max(pick, skip);
                } else {
                    int skip = dp[index - 1][remWeight];
                    int pick = 0;
                    if (weight[index] <= remWeight) pick = value[index] + dp[index - 1][remWeight - weight[index]];
                    dp[index][remWeight] = Math.max(pick, skip);
                }
            }
        }
        return dp[n - 1][maxWeight];
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
//         return solveMemo(weight, value, n - 1, maxWeight, dp);
        return solveTab(weight, value, n, maxWeight);
    }
}
