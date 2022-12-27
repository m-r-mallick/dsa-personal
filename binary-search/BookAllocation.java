/** Allocate Books */

/* You have to assign books to the students in such a way that the maximum number of pages assigned to a student is minimum */

/** Example */

/* 
2
4 2
12 34 67 90
4 4
5 17 100 11 
*/

/** Solution */

import java.util.*;
public class BookAllocation {
    public static int sumList(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
    public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int mid) {
        int students = 1;
        int pageSum = 0;
        for (int i : arr) {
            if (pageSum + i <= mid) {
                pageSum += i;
            } else {
                students++;
                if (students > m || i > mid) return false;
                pageSum = i;
            }
        }
        return true;
    }
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int start = 0, end = sumList(arr), ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

