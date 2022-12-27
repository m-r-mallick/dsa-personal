import java.util.*;
public class UniquePaths {
	public static int calculate(int m, int n, int[][] dp) {
		if (m == 0 && n == 0) return 1;
		if (m < 0 || n < 0) return 0;
		if (dp[m][n] != -1) return dp[m][n];
		int up = calculate(m - 1, n, dp);
		int left = calculate(m, n - 1, dp);
		return dp[m][n] = up + left;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] dp = new int[m][n];
		for (int[] row : dp) Arrays.fill(row, -1);
		System.out.println(calculate(m - 1, n - 1, dp));
		for (int[] row : dp) System.out.println(Arrays.toString(row));
	}
}
