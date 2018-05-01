import java.util.*;

class Solution {
	Solution() {}

	public int getExtra(int[] a, int[] b) {
		if (a == null || b == null || a.length + 1 != b.length) {
			return 0;
		}
		int res = 0;
		int i;
		for (i = 0; i < a.length; i++) {
			res = res^a[i]^b[i];
			System.out.println(res);
		}
		return res^b[i];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = new int[] {1, 2, 3, 4, 5};
		int[] b = new int[] {3, 6, 2, 1, 4, 5};
		int res = solution.getExtra(a, b);
	}
}