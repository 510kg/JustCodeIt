class Solution {
	Solution() {}
    
    //My Solution
    public int removeDuplicates1(int[] nums) {
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

    //Most Voted
    public int removeDuplicates2(int nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length < 2) {
    		return nums.length;
    	}
    	int count = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] != nums[i - 1]) {
    			nums[count++] = [nums[i];
    		}
    	}
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[] {1, 1, 1, 2, 2, 3};
        int[] nums2 = new int[] {0, 0, 0, 0, 0, 0};
        int[] nums3 = new int[] {1, 2, 3, 4, 5, 6};

        int count1 = solution.removeDuplicates1(nums1);
        int count2 = solution.removeDuplicates1(nums2);
        int count3 = solution.removeDuplicates1(nums3);

        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

	}
}