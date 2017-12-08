import java.util.*;

class Solution {
	Solution() {}

	public List<List<Integer>> combinationSumWithDups(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return results;
		}
		List<Integer> combination = new ArrayList<Integer>();
		dfsHelper(results, candidates, target, combination, 0);
		return results;
	}

	private void dfsHelper(List<List<Integer>> results, int[] candidates, int target, List<Integer> combination, int start) {
		if (target < 0) {
			return ;
		} else if (target == 0) {
			results.add(new ArrayList<Integer>(combination));
			return ;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			combination.add(candidates[i]);
			dfsHelper(results, candidates, target - candidates[i], combination, start + 1);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}