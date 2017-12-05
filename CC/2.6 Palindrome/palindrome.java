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

	public boolean palindromeList(ListNode head) {
		if (head == null) {
			return false;
		}
		/*
		if (head.next == null) {
			return true;
		}
		*/
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode newHead = slow.next;
		ListNode prev = null;
		while (newHead != null) {
			ListNode temp = newHead.next;
			newHead.next = prev;
			prev = newHead;
			newHead = temp;
		}

		while (prev != null) {
			if (prev.val != head.val) {
				return false;
			}
			head = head.next;
			prev = prev.next;
		}

		return true;
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

		int[] vals = new int[] {1, 2, 3, 4, 3, 2, 1};
		ListNode head = solution.converter(vals);

		boolean result = solution.palindromeList(head);

		System.out.println(result);
	}
}