import java.util.*;

class Solution {
	Solution() {}

	public int[][] zeroMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return matrix;
		}
		boolean firstRow = true;
		boolean firstCol = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstCol = false;
				break;
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				firstRow = false;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (!firstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (!firstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] matrix1 = new int[][] {{1, 0, 3, 4, 5}, {0, 7, 8, 9, 10}, {11, 12, 13, 0, 15}, {0, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		int[][] matrix2 = new int[][] {{0,0,0,5}, {4,3,1,4}, {0,1,1,4}, {1,2,1,3}, {0,0,1,1}};
		int[][] result = solution.zeroMatrix(matrix2);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println(";");
		}
	}
}