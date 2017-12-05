import java.util.*;

class Solution1 {
	Solution1() {}

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
		
		ListNode dummy = null;
		ListNode prev = dummy;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
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
		Solution1 solution = new Solution1();

		int[] vals = new int[] {1, 2, 3, 4, 5};
		ListNode head = solution.converter(vals);

		ListNode result = solution.reverseList(head);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}