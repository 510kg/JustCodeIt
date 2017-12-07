import java.util.*;

class Solution {
    Solution() {}

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        List<Integer> combination = new ArrayList<Integer>();
        dfsHelper(results, nums, combination, 0);
        return results;
    }

    private void dfsHelper(List<List<Integer>> results, int[] nums, List<Integer> combination, int start) {
        results.add(new ArrayList<Integer>(combination));
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            dfsHelper(results, nums, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> results = solution.subsets(nums);

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println(";");
        }
    }
}