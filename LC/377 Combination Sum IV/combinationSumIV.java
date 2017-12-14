import java.util.*;

class Solution {
    Solution() {}

    //basic recursive
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        } 
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += combinationSum4(nums, target - nums[i]);
        }
        return result;
    }

    //DP+Recursive top-down
    private int[] dp;

    public int combinationSum4DP1(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += helper(nums, target - nums[i]);
            }
        }
        dp[target] = result;
        return result;
    }

    //DP bottom-up
    public int combinationSum4DP2(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }

        return comb[target];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {1, 2, 3};
        int target = 4;

        int result = solution.combinationSum4DP2(nums, target);
        System.out.println(result);
    }
}