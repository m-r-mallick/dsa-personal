import java.util.*;
public class MinimumPathSum {
	public static int[][] generateRandomMatrix(int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = (int) (Math.random() * 9 + 1);
			}
		}
		return matrix;
	}
	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	public static int solve(int[][] arr, int i, int j) {
		if (i == 0 && j == 0) return arr[i][j];
		if (i < 0 || j < 0) return Integer.MAX_VALUE;
		int up = arr[i][j] + solve(arr, i - 1, j);
		int left = arr[i][j] + solve(arr, i, j - 1);
		return Math.min(up, left);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Rows = ");
		int rows = sc.nextInt();
		System.out.print("Columns = ");
		int cols = sc.nextInt();
		var matrix = generateRandomMatrix(rows, cols);
		printMatrix(matrix);
		System.out.println("Minimum Path Sum = " + solve(matrix, rows - 1, cols - 1));
	}
}
