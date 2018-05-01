import java.util.*;

class Solution {
    Solution() {}

    public int[] pqTest(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        for (int num: nums) {
            pq.offer(num);
        }

        int k = nums.length;
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll();
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {8, 6, 9, 2, 5, 4, 1, 3, 7};
        int[] results = solution.pqTest(nums);
        for (int result: results) {
            System.out.println(result);
        }
    }
}
