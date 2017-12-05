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

	public ListNode sumLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode newHead = new ListNode(0);
		ListNode curr = newHead;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
		}

		if (sum / 10 == 1) {
			curr.next = new ListNode(1);
		}

		return newHead.next;
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

		int[] vals1 = new int[] {7, 1, 6};
		int[] vals2 = new int[] {5, 9, 3};
		ListNode l1 = solution.converter(vals1);
		ListNode l2 = solution.converter(vals2);

		ListNode result = solution.sumLists(l1, l2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}