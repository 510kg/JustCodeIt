import java.util.*;

class Solution2 {
	Solution2() {}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode tail = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return tail;
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
		Solution2 solution = new Solution2();

		int[] vals = new int[] {1, 2, 3, 4, 5};
		ListNode head = solution.converter(vals);

		ListNode result = solution.reverseList(head);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}