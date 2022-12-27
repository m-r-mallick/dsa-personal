/** Merge Sort */

public class MergeSort {
    public static void merge(int arr[], int start, int end) {
        int mid = start + (end - start) / 2;
        int l1 = mid - start + 1;
        int l2 = end - mid;
        int[] t1 = new int[l1];
        int[] t2 = new int[l2];
        
        int mainArrPtr = start;
        for (int i = 0; i < l1; i++) {
            t1[i] = arr[mainArrPtr++];
        }
        
        for (int i = 0; i < l2; i++) {
            t2[i] = arr[mainArrPtr++];
        }
        
        int index1 = 0;
        int index2 = 0;
        mainArrPtr = start;
        while (index1 < l1 && index2 < l2) {
            if (t1[index1] < t2[index2]) {
                arr[mainArrPtr++] = t1[index1++];
            } else {
                arr[mainArrPtr++] = t2[index2++];
            }
        }
        while (index1 < l1) {
            arr[mainArrPtr++] = t1[index1++];
        }
        while (index2 < l2) {
            arr[mainArrPtr++] = t2[index2++];
        }
    }
    public static void solve(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        solve(arr, start, mid);
        solve(arr, mid + 1, end);
        merge(arr, start, end);
    }
	public static void mergeSort(int[] arr, int n) {
		solve(arr, 0, n - 1);
	}
}
