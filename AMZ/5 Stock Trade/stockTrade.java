//input is array or list
//what to return if no profit

import java.util.*;
//time:n    space:c
class Solution {
	Solution() {}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int curDiff = 0;
		int maxDiff = 0;

		for (int i = 1; i < prices.length; i++) {
			curDiff = Math.max(0, curDiff + prices[i] - prices[i - 1]);
			maxDiff = Math.max(maxDiff, curDiff);
		}

		return maxDiff;

/* 
		int curr = 0;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				curr = prices[j] - prices[i];
				max = Math.max(max, curr);
			}
		}
		return max;
	}
*/

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices1 = new int[] {7, 1, 5, 3, 6, 4};
		int[] prices2 = new int[] {7, 6, 4, 3, 1};
		int result1 = solution.maxProfit(prices1);
		int result2 = solution.maxProfit(prices2);
		System.out.println(result2);
	}
}