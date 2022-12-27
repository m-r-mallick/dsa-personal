/** Possible Palindrome Partitions */

import java.util.*;

class PalindromePartitions {
    static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
    static void solve(String str, int index, ArrayList<String> output, ArrayList<ArrayList<String>> ans) {
        if (index >= str.length()) {
            ans.add(new ArrayList<>(output));
            return;
        }
        String temp;
        for (int i = index; i < str.length(); i++) {
            temp = str.substring(index, i + 1);
            if (isPalindrome(temp)) {
                output.add(temp);
                solve(str, i + 1, output, ans);
                output.remove(output.size() - 1);
            }
        }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String str) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        ArrayList<String> output = new ArrayList<String>();
        solve(str, 0, output, ans);
        return ans;
    }
	 public static void main(String[] args) {
		 String str = "RACEVENEVECAR";
		 System.out.println(allPalindromicPerms(str));
	 }
};
