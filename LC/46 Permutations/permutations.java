import java.util.*;

class Solution {
    Solution() {}

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        //Arrays.sort(nums);
        List<Integer> combination = new ArrayList<Integer>();
        dfsHelper(results, nums, combination);
        return results;
    }

    private void dfsHelper(List<List<Integer>> results, int[] nums, List<Integer> combination) {
        if (combination.size() == nums.length) {
            results.add(new ArrayList<Integer>(combination));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (combination.contains(nums[i])) {
                continue;
            }
            combination.add(nums[i]);
            dfsHelper(results, nums, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> permuteNonRecursive(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        int n = nums.length;
        List<Integer> stack = new ArrayList<Integer>();
        stack.add(-1);
        while (!stack.isEmpty()) {
            int last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }

            if (next == -1) {
                continue;
            }

            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }

            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                result.add(nums[stack.get(i)]);
            }
            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[] {1, 3, 2};

        List<List<Integer>> results1 = solution.permute(nums1);
        List<List<Integer>> results2 = solution.permuteNonRecursive(nums1);

        for (int i = 0; i < results1.size(); i++) {
            for (int j = 0; j < results1.get(i).size(); j++) {
                System.out.println(results1.get(i).get(j));
            }
            System.out.println(";");
        }

        for (int i = 0; i < results2.size(); i++) {
            for (int j = 0; j < results2.get(i).size(); j++) {
                System.out.println(results2.get(i).get(j));
            }
            System.out.println(";");
        }
    }
}