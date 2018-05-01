import java.util.*;

class Solution {
	Solution() {}

	public void prints(int d) {
		if (d <= 0) {
			return ;
		} else {
			prints(d / 10);
		}
		System.out.println(d % 10);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		solution.prints(1916);
	}
}