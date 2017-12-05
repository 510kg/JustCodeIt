import java.util.*;

class Solution3 {
	Solution3() {}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}

	public void reverseList(ListNode head) {
		if (head == null) {
			return ;
		}
		reverseList(head.next);
		System.out.println(head.val);
	}


	private ListNode converter(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode curr = head;
		for (int i = 1; i < nums.length; i++) {
			curr.next = new ListNode(nums[i]);
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();

		int[] vals = new int[] {1, 2, 3, 4, 5};
		ListNode head = solution.converter(vals);

		solution.reverseList(head);
	}
}