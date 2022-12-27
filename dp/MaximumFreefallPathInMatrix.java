import java.util.* ;
import java.io.*; 

public class MaximumFreefallPathInMatrix {
    public static int solve(int i, int j, int[][] matrix, int rows, int cols, int[][] dp) {
        if (j == cols || j == -1) return (int) -1e9;
        if (dp[i][j] != -1) return dp[i][j];
        if (i == rows - 1) return matrix[i][j];
        int dwn = matrix[i][j] + solve(i + 1, j, matrix, rows, cols, dp);
        int lt_dgnl = matrix[i][j] + solve(i + 1, j - 1, matrix, rows, cols, dp);
        int rt_dgnl = matrix[i][j] + solve(i + 1, j + 1, matrix, rows, cols, dp);
        return dp[i][j] = Math.max(dwn, Math.max(lt_dgnl, rt_dgnl));
    }
	public static int getMaxPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
        for (int[] row: dp) Arrays.fill(row, -1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < cols; i++) {
            ans = Math.max(ans, solve(0, i, matrix, rows, cols, dp));
        }
        return ans;
	}
}

