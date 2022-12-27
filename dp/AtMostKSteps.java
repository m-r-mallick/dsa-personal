import java.util.*;
public class AtMostKSteps {
	public static int solve(int n, int k, int[] dp) {
		if (n == 0) return 1;
		if (n == 1) return 1;

		if (dp[n] != -1) return dp[n];
		int sum = 0;
		for (int i = 1; i <= k; i++) {
			if (n - i < 0) break;
			sum += solve(n - i, k, dp);
		}
		return dp[n] = sum;
	}
	public static void main(String[] args) {
		long start, end;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		start = System.currentTimeMillis();
		System.out.println(solve(n, k, dp));
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}
}
