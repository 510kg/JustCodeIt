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

	public ListNode removeDups(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		Set<Integer> set = new HashSet<Integer>();
		ListNode dummy = null;
		ListNode prev = dummy;
		ListNode curr = head;

		while (curr != null) {
			if (!set.contains(curr.val)) {
				set.add(curr.val);
				prev = curr;
			} else {
				prev.next = curr.next;
			}
			curr = curr.next;
		}

		return head;
	}

	public ListNode removeDupsInSpace(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;

		while (slow != null) {
			ListNode fast = slow;
			while (fast.next != null) {
				if (slow.val == fast.next.val) {
					fast.next = fast.next.next;
				} else {
					fast = fast.next;
				}
			}
			slow = slow.next;
		}

		return head;
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
		Solution solution = new Solution();

		int[] vals = new int[] {1, 3, 5, 1, 1, 5, 3};
		ListNode head1 = solution.converter(vals);
		ListNode head2 = solution.converter(vals);
		ListNode result1 = solution.removeDups(head1);
		ListNode result2 = solution.removeDupsInSpace(head2);

		while (result1 != null) {
			System.out.println(result1.val);
			result1 = result1.next;
		}

		System.out.println(";");

		while (result2 != null) {
			System.out.println(result2.val);
			result2 = result2.next;
		}
	}
}