/** String Permutations */

import java.util.*;

public class StringPermutations {
    public static void swap(char[] arr, int i, int j) {
        char temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static String getStringFromArray(char[] arr) {
        String res = "";
        for (char i : arr) {
            res += i;
        }
        return res;
    }
    public static void solve(char[] arr, int index, ArrayList<String> ans) {
        if (index >= arr.length) {
            ans.add(getStringFromArray(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            solve(arr, index + 1, ans);
            swap(arr, index, i);
        }
    }
	public static ArrayList<String> generatePermutations(String str) {
	    char[] arr = str.toCharArray();
        ArrayList<String> ans = new ArrayList<String>();
        solve(arr, 0, ans);
        Collections.sort(ans);
        return ans;
	}
}
