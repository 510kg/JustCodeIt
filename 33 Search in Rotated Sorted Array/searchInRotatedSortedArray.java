class Solution {
    Solution() {}

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {//2, 4, 5, 6, 7, 0, 1
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {//5, 6, 7, 0, 1, 2, 4
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[] {2, 4, 5, 5, 5, 6, 7, 0, 1};
        int[] nums2 = new int[] {5, 6, 7, 0, 1, 2, 2, 2, 2, 2, 2, 4};
        int target1 = 5;
        int target2 = 0;
        int target3 = 6;
        int target4 = 2;

        int res1 = solution.search(nums1, target1);
        int res2 = solution.search(nums1, target2);
        int res3 = solution.search(nums2, target3);
        int res4 = solution.search(nums2, target4);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}