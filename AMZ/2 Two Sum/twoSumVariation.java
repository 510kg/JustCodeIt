//input is array or list
//what to return if target doesn't exist
//duplicates in input or in output
//return value?

import java.util.*;
//time:nlogn   space:n
class Solution {
	public Solution() {}

	public List<List<Integer>> twoSumVariation(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 2) {
			return results;
		}
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int num = nums[left] + nums[right];
			if (num == target) {
				List<Integer> result = new ArrayList<Integer>();
				result.add(nums[left]);
				result.add(nums[right]);
				results.add(result);
				while (left + 1 < right && nums[left] == nums[left + 1]) {
					left++;
				}
				while (right - 1 > left && nums[right - 1] == nums[right]) {
					right--;
				}
				left++;
				right--;
			} else if (num > target) {
				right--;
			} else {
				left++;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[] {1, 3, 6, 3, 2, 9, 4, 1, 9, 10};
		int[] nums2 = new int[] {1, 1, 1, 1, 8, 9, 9, 9, 9};
		int target = 10;
		List<List<Integer>> results = solution.twoSumVariation(nums1, target);
		for (int i = 0; i < results.size(); i++) {
			for (int j = 0; j < results.get(i).size(); j++) {
				System.out.println(results.get(i).get(j));
			}
			System.out.println(";");
		}
	}
}