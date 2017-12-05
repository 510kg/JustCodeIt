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

	public void deleteMid(ListNode head) {
		if (head == null) {
			return ;
		}
		head.val = head.next.val;
		head.next = head.next.next;
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

		int[] vals = new int[] {1, 2, 3, 4, 5, 6, 7};
		ListNode head = solution.converter(vals);

		solution.deleteMid(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}