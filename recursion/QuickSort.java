/** Quick Sort */

public class QuickSort {
    public static void swap(int[] arr, int pos1, int pos2) {
        int temp;
        temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotFinalPos = start;
        for (int i = start + 1; i <= end; i++) {
            if (i < pivot) pivotFinalPos++;
        }
        swap(arr, start, pivotFinalPos);
        int index1 = start, index2 = end;
        while (index1 < pivotFinalPos && index2 > pivotFinalPos) {
            // both pointing to legal occupants
            if (arr[index1] < pivot && arr[index2] >= pivot) {
                index1++;
                index2--;
                continue;
            }
            // i1 is pointing to illegal occupant, but i2 is pointing to legal
            if (arr[index1] >= pivot && arr[index2] >= pivot) {
                index2--;
                continue;
            } 
            // i1 is pointing to legal occupant, but i2 is pointing to illegal
            if (arr[index1] < pivot && arr[index2] < pivot) {
                index1++;
                continue;
            }
            // both pointing to illegal occupants
            if (arr[index1] >= pivot && arr[index2] < pivot) {
                swap(arr, index1, index2);
                index1++;
                index2--;
                continue;
            }
        }
        return pivotFinalPos;
    }
    public static void solve(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int p = partition(arr, start, end);
		  System.out.println("Partition position = " + p);
        solve(arr, start, p - 1);
        solve(arr, p + 1, end);
    }
	 public static void main(String[] args) {
		 int[] arr = {23, 12, 8, 54, 77, 41, 13};
		 solve(arr, 0, arr.length - 1);
		 for (int i : arr) {
			 System.out.print(i + ", ");
		 }
	 }
}
