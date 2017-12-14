import java.util.*;

class Solution {
	Solution() {}

	public String compress(String s) {
		if (s == null || s.length() <= 2) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		int curr = 0;
		if (!judge(s)) {
			return s;
		};
		while (curr < s.length()) {
			if (curr == s.length() - 1 || s.charAt(prev) != s.charAt(curr + 1)) {
				int count = curr - prev + 1;
				sb.append(s.charAt(prev));
				sb.append(String.valueOf(count));
				prev = curr + 1;
			}
			curr++;
		}
		return sb.toString();
	}

	private boolean judge(String s) {
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				count++;
			}
		}
		if (s.length() <= 2 * count) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "aaabbbccccc";
		String result = solution.compress(s);

		System.out.println(result);
	}
}