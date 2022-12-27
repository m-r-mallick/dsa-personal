
public class BSIterative { 

    public static int binarySearch(int[] arr, int x) {
    	//Your code goes here
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }

}
