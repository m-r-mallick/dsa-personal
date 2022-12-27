/** Aggressive Cows Problem */

/* Assign the cows to the stalls such that the minimum distance between each of them is maximum */

import java.util.*;

public class AggressiveCows
{
    public static boolean isPossible(ArrayList<Integer> stalls, int k, int mid) {
        int cowsPlaced = 1;
        int lastPos = stalls.get(0);
        for (int i : stalls) {
            if (i - lastPos >= mid) {
                cowsPlaced++;
                if (cowsPlaced == k) return true;
                lastPos = i;
            }
        }
        return false;
    }
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
        Collections.sort(stalls);
        int start = 0, end = stalls.get(stalls.size() - 1), ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
