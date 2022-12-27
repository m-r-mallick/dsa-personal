import java.util.*;
public class CustomFibonacci {
	public static void printSumOfFirstNOdd(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		int count = 0;
		long sum = 0;
		int i = 3;
		while (count < n - 2) {
			int val = list.get(i - 1) + list.get(i - 2) + list.get(i - 3);
			list.add(val);
			if (val % 2 != 0) {
				sum += val;
				count++;
			}
			i++;
		}
		sum += 4;
		System.out.println(list);
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printSumOfFirstNOdd(n);
	}
}
