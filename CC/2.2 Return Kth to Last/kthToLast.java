import java.util.*;

class Solution {
	Solution() {}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode kthToLast(ListNode head, int k) {
		if (head == null || k < 0) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode converter(int[] vals) {
		ListNode head = new ListNode(vals[0]);
		ListNode curr = head;
		for (int i = 1; i < vals.length; i++) {
			curr.next = new ListNode(vals[i]);
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] vals = new int[] {7, 6, 5, 4, 3, 2, 1};
		ListNode head = solution.converter(vals);
		int k = 3;

		ListNode result = solution.kthToLastRecursive(head, k);

		System.out.println(result.val);
	}
}