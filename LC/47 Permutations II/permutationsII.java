import java.util.*;

class Solution {
	Solution() {}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null) {
			return results;
		}
		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}

		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		List<Integer> result = new ArrayList<Integer>();
		dfsHelper(results, nums, used, result);

		return results;
	}

	private void dfsHelper(List<List<Integer>> results, int[] nums, boolean[] used, List<Integer> result) {
		if (result.size() == nums.length) {
			results.add(new ArrayList<Integer>(result));
			return ;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
				continue;
			}

			result.add(nums[i]);
			used[i] = true;
			dfsHelper(results, nums, used, result);
			result.remove(result.size() - 1);
			used[i] = false;
		}
	}


	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = new int[] {1, 1, 2, 3};
		List<List<Integer>> results = solution.permuteUnique(nums);

		for (int i = 0; i < results.size(); i ++) {
			for (int j = 0; j < results.get(i).size(); j++) {
				System.out.println(results.get(i).get(j));
			}
			System.out.println(";");
		}
	}
}