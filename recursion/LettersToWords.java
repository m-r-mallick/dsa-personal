/** Given a set of size N, containing N distinct characters, find all the possible strings of size 'K' that can be generated */

import java.util.*;
public class LettersToWords {
	public static void solve(char[] chars, List<String> ans, String output, int outputSize) {
		if (output.length() == outputSize) {
			ans.add(output);
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			char el = chars[i];
			String temp = new String(output);
			temp += el;
			solve(chars, ans, temp, outputSize);
		}
		
	}
	public static void main(String[] args) {
		List<String> ans = new ArrayList<>();
		String output = "";
		char[] chars = {'a', 'b', 'c', 'd', 'e'};
		int outputSize = 3;
		solve(chars, ans, output, outputSize);
		System.out.println(ans);
	}
}
