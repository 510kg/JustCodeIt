class Solution {
	Solution() {}

    public int removeDuplicates(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int fast = 0, slow = 0;
    	while (fast < nums.length) {
    		nums[slow++] = nums[fast++];
    		while (fast < nums.length && nums[fast] == nums[fast - 1]) {
    			fast++;
    		}
    	}
    	
    	return slow;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[] {1, 1, 1, 2, 2, 3};
        int[] nums2 = new int[] {0, 0, 0, 0, 0, 0};
        int[] nums3 = new int[] {1, 2, 3, 4, 5, 6};

        int count1 = solution.removeDuplicates(nums1);
        int count2 = solution.removeDuplicates(nums2);
        int count3 = solution.removeDuplicates(nums3);

        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

	}
}