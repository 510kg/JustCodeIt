import java.util.*;

class Solution {
    Solution() {}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        //Arrays.sort(candidates);
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
            combination.add(candidates[i]);
            dfsHelper(results, candidates, target - candidates[i], combination, i);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = new int[] {2, 3, 6, 7, 8, 9, 10};
        int target = 7;

        List<List<Integer>> results = solution.combinationSum(candidates, target);

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println(";");
        }
    }
}