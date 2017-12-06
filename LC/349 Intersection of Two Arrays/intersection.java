import java.util.*;

class Solution {
	Solution() {}

	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
        	return null;
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for (int num : nums1) {
        	set.add(num);
        }
        for (int num : nums2) {
        	if (set.contains(num)) {
        		intersect.add(num);
        	}
        }
        int[] result = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
        	result[index++] = num;
        }
        return result;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums1 = new int[] {1, 2, 2, 1};
		int[] nums2 = new int[] {2, 2};

		int[] result = solution.intersection(nums1, nums2);

		for (int num : result) {
			System.out.println(num);
		}
	}
}