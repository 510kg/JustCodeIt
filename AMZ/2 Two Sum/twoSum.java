import java.util.*;

class Solution {
	public Solution() {}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length < 2) {
			return result;
		}

		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(target - nums[i])) {
				result[0] = hash.get(target - nums[i]);
				result[1] = i;
			} else {
				hash.put(nums[i], i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {2, 2, 2, 7, 11, 15};
		int target = 9;
		int[] result = solution.twoSum(nums, target);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}