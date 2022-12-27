import java.util.*;
public class SpecialShop {
	public static void solve(int n, int a, int b, int x, int y, Set<Integer> ans) {
		if (n == 0) {
			int cost = a * x * x + b * y * y;
			ans.add(cost);
			return;
		}
		// picking A
		solve(n - 1, a, b, x + 1, y, ans);
		// picking B
		solve(n - 1, a, b, x, y + 1, ans);
	}
	public static void main(String[] args) {
		Set<Integer> ans = new TreeSet<>();
		int n = 5, a = 1, b = 2;
		solve(n, a, b, 0, 0, ans);
		System.out.println(new ArrayList<>(ans).get(0));
	}
}
