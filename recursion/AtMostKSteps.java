import java.util.*;
public class AtMostKSteps {
	public static void calculate(int dist, int k, List<Integer> ans) {
		if (dist == 0) {
			ans.add(1);
			return;
		}
		for (int i = 0; i < k; i++) {
			int steps = i + 1;
			if (dist - steps >= 0) calculate(dist - steps, k, ans);
			else break;
		}
	}
	public static void main(String[] args) {
		long start, end;
		Scanner sc = new Scanner(System.in);
		System.out.print("Distance = ");
		int dist = sc.nextInt();
		System.out.print("k = ");
		int k = sc.nextInt();
		List<Integer> ans = new ArrayList<>();
		start = System.currentTimeMillis();
		calculate(dist, k, ans);
		end = System.currentTimeMillis();
		System.out.println(ans.size());
		System.out.println(end - start + "ms");
	}
}
