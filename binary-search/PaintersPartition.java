/** Painters Partition Problem */

/* Return the value of the minimum time required to paint all the boards if painters can paint only consecutive sections */

import java.util.*;

public class PaintersPartition 
{
    public static int getSum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
    public static boolean isPossible(ArrayList<Integer> boards, int k, int mid) {
        int painters = 1;
        int capSum = 0;
        for (int i : boards) {
            if (capSum + i <= mid) {
                capSum += i;
            } else {
                painters++;
                if (painters > k || i > mid) {
                    return false;
                }
                capSum = i;
            }
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int start = 0, end = getSum(boards), ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(boards, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
