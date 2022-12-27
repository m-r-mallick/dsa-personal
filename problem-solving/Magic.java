import java.util.*;
public class Magic {
	public static void findMagic(int x, int n) {
		String orig = String.valueOf(x);
		char[] t1 = orig.toCharArray();
		char[] t2 = new char[t1.length];
		for (int i = 0; i < t1.length; i++) {
			int el = Integer.parseInt(String.valueOf(t1[i]));
			el = (el + n) % 10;
			t2[i] = String.valueOf(el).charAt(0);
		}
		String res = new String(t2);
		System.out.println(Integer.parseInt(res));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		findMagic(x, n);
	}
}
