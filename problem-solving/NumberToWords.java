/** Covert given number to words */

import java.util.*;
class NumberToWords {
    public static String solve(int n) {
        String ans = "";
        int temp = n;
        Stack<String> stack = new Stack<>();
        String[] num0to19 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tenMults = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int lastNum;
		  if (n == 0) return "zero";
		  if (n == 10000) return "ten thousand";
        for (int i = 10; i <= 10000; i = i * 10) {
            if (temp == 0) break;
            int rem = temp % i;
            if (rem >= 0 && rem <= 19) {
                stack.push(num0to19[rem]);
            }
            if (rem > 19 && rem <= 99) {
                stack.push(tenMults[rem / 10]);
            }
            if (rem > 99 && rem <= 999) {
                stack.push(num0to19[rem / 100] + " hundred");
            }
            if (rem > 999 && rem <= 9999) {
					stack.push(num0to19[rem / 1000] + " thousand");
				}
            temp = temp - rem;
        }
        
        while (!stack.empty()) {
            ans += stack.pop() + " ";
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
