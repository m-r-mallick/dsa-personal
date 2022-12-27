import java.util.*;
class Subsets {
   public static void solve(int[] arr, int index, List<Integer> output, List<List<Integer>> ans) {
        if (index >= arr.length) {
            ans.add(output);
            // output.clear();
            return;
        }
//         exclude
        solve(arr, index + 1, output, ans);
//         include
        List<Integer> tempOutput = new ArrayList<Integer>(output);
        int el = arr[index];
        tempOutput.add(el);
        solve(arr, index + 1, tempOutput, ans);
    } 
	public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        if (arr.length != 0) {
            solve(arr, 0, output, ans);
        }
        return ans;
    }
	 public static void main(String[] args) {
		 int[] arr = {1, 2, 3, 4, 5};
		 var res = subsets(arr);
		 System.out.println(res);
	 }
}
