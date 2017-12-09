import java.util.*;

class Solution {
    Solution() {}

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (k <= 0 || k > 9 || n < 1 || n > 45) {
            return results;
        }
        List<Integer> combination = new ArrayList<Integer>();
        dfsHelper(results, k, n, combination, 1);
        return results;
    }

    private void dfsHelper(List<List<Integer>> results, int k, int n, List<Integer> combination, int start) {
        if (n < 0 || combination.size() > k) {
            return ;
        } else if (n == 0 && combination.size() == k) {
            results.add(new ArrayList<Integer>(combination));
        }
        for (int i = start; i <= 9; i++) {
            combination.add(i);
            dfsHelper(results, k, n - i, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 3;
        int n = 9;
        List<List<Integer>> results = solution.combinationSum3(k, n);

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println(";");
        }
    }
}