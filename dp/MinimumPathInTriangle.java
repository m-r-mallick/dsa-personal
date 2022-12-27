/** Calculate minimum freefall cost in a triangular matrix of height 'n'
 *
 * possible movements -> down/diagonal*/

import java.util.* ;
import java.io.*; 
public class MinimumPathInTriangle {
    public static int solve(int i, int j, int[][] triangle, int n, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == n - 1) return triangle[i][j];
        int dwn = triangle[i][j] + solve(i + 1, j, triangle, n, dp);
        int dgnl = triangle[i][j] + solve(i + 1, j + 1, triangle, n, dp);
        return dp[i][j] = Math.min(dwn, dgnl);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int[] row: dp) Arrays.fill(row, -1);
        return solve(0, 0, triangle, n, dp);
    }
}
