import java.util.*;

class Solution {
	Solution() {}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
        	return results;
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                continue;
            }
        	int left = 0;
        	int right = i - 1;
        	while (left < right) {
        		int sum = nums[left] + nums[right] + nums[i];
        		if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    results.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                    	left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                    	right--;
                    }
        		} else if (sum > 0) {
        			right--;
        		} else {
        			left++;
        		}
        	}
        }

        return results;
	}

	public static void main(String[] args) {
    	Solution solution = new Solution();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0};

		List<List<Integer>> results1 = solution.threeSum(nums1);
		List<List<Integer>> results2 = solution.threeSum(nums2);

		for (List<Integer> list : results1) {
			for (int num : list) {
				System.out.println(num);
			}
			System.out.println(";");
		}

        for (List<Integer> list : results2) {
            for (int num : list) {
                System.out.println(num);
            }
            System.out.println(";");
        }
	}
}
