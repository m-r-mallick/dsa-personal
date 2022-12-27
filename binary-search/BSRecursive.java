public class BSRecursive { 
    public static int binarySearch(int[] arr, int lb, int ub, int key) {
        if (lb > ub) return -1;
        int mid = lb + (ub - lb) / 2;
        if (arr[mid] == key) return mid;
        if (arr[mid] < key) return binarySearch(arr, mid + 1, ub, key);
        if (arr[mid] > key) return binarySearch(arr, lb, mid - 1, key);
        return -1;
    }
}
