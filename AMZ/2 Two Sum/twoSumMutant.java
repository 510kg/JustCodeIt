import java.util.*;

class Solution {
	public Solution() {}

	public List<List<Integer>> twoSumMutant(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 2) {
			return results;
		}

		Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			int num2 = target - num1;
			if (hash.containsKey(num1)) {
				hash.get(num1).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				hash.put(num1, list);
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
			int num1 = entry.getKey();
			int num2 = target - num1;
			if (hash.containsKey(num2)) {
				for (int i = 0; i < hash.get(num1).size(); i++) {
					for (int j = 0; j < hash.get(num2).size(); j++) {
						List<Integer> result = new ArrayList<Integer>();
						result.add(hash.get(num2).get(j));
						result.add(hash.get(num1).get(i));
						results.add(result);
					}
				}
			}
		}

		return results;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {1, 9, 9, 1};
		int target = 10;
		List<List<Integer>> results = solution.twoSumMutant(nums, target);
		for (int i = 0; i < results.size(); i++) {
			for (int j = 0; j < results.get(i).size(); j++) {
				System.out.println(results.get(i).get(j));
			}
			System.out.println(";");
		}
	}
}