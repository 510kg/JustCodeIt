import java.util.*;
//HashMap
class Solution {
    public Solution() {}

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;
            if (hash.containsKey(num2)) {//in case of duplicate values
                result[0] = hash.get(num2);//change the order of num1 and num2
                result[1] = i;//index2 must larger than index1
            } else {
                hash.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 2, 3, 4, 7, 8};
        int target1 = 6;
        int target2 = 8;

        int[] result1 = solution.twoSum(nums, target1);
        int[] result2 = solution.twoSum(nums, target2);

        for (int result : result1) {
            System.out.println(result);
        };
        System.out.println(";");
        for (int result : result2) {
            System.out.println(result);
        };
    }
}
