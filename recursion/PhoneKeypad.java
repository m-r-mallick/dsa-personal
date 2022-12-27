/** Phone Keypad Problem */

// topic - recursion + backtracking

import java.util.*;

public class PhoneKeypad 
{
    static Map<Integer, String> map = new HashMap<Integer, String>();
    public static void solve(String digits, int index, String output, ArrayList<String> ans) {
        if (index >= digits.length()) {
            ans.add(output);
            return;
        }
        int number = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String mapping = map.get(number);
        for (int i = 0; i < mapping.length(); i++) {
            output += mapping.charAt(i);
            solve(digits, index + 1, output, ans);
            output = output.substring(0, output.length() - 1);
        }
    }
    public static ArrayList<String> combinations(String digits){
	     map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        ArrayList<String> ans = new ArrayList<String>();
        String output = "";
        if (digits.length() > 0) {
            solve(digits, 0, output, ans);
        }
        return ans;
	}
	public static void main(String[] args) {
		String digits = "795";
		System.out.println(combinations(digits));
	}
}
