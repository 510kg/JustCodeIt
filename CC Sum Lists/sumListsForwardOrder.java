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

	public ListNode sumListsForwardOrder(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		ListNode list = null;
		int sum = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			sum /= 10;
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			ListNode curr = new ListNode(sum % 10);
			curr.next = list;
			list = curr;
		}
		if (sum / 10 == 1) {
			ListNode head = new ListNode(1);
			head.next = list;
			list = head;
		}
		return list;
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

		int[] vals1 = new int[] {7, 2, 4 , 3};
		int[] vals2 = new int[] {3, 5, 6, 4};
		ListNode l1 = solution.converter(vals1);
		ListNode l2 = solution.converter(vals2);

		ListNode result = solution.sumListsForwardOrder(l1, l2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}