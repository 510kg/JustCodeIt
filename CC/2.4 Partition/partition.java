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

	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode start = head;
		ListNode tail = head;
		while (head != null) {
			ListNode next = head.next;
			if (head.val < target) {
				head.next = start;
				start = head;
			} else {
				tail.next = head;
				tail = head;
			}
			head = next;
		}
		tail.next = null;

		return start;
	}

	public ListNode partitionStable(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			if (head.val < target) {
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = head;
				} else {
					beforeEnd.next = head;
					beforeEnd = beforeEnd.next;
				}
			} else {
				if (afterStart == null) {
					afterStart = head;
					afterEnd = head;
				} else {
					afterEnd.next = head;
					afterEnd = afterEnd.next;
				}
			}
			head = next;
		}

		if (beforeEnd == null) {
			return afterStart;
		}

		beforeEnd.next = afterStart;

		return beforeStart;
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

		int[] vals = new int[] {3, 5, 8, 5, 10, 2, 1};
		ListNode head = solution.converter(vals);

		ListNode result = solution.partitionStable(head, 5);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}