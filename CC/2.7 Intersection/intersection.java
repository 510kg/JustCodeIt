import java.util.*;

class Solution {
	Solution() {}

	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode intersection(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode curr1 = headA;
		ListNode curr2 = headB;
		while (curr1 != curr2) {
			if (curr1 == null) {
				curr1 = headB;
			} else {
                curr1 = curr1.next;
            }
			if (curr2 == null) {
				curr2 = headA;
			} else {
			    curr2 = curr2.next;
            }
		}
		return curr1;
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

	public void run(String[] args) {
		int[] vals1 = new int[] {1, 2, 3, 6, 7, 8};
		ListNode head1 = converter(vals1);
		ListNode head2 = new ListNode(4);
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		curr2.next = new ListNode(5);
		curr2 = curr2.next;
		for (int i = 0; i < 3; i++) {
			curr1 = curr1.next;
		}
		curr2.next = curr1;

		ListNode intersect = intersection(head1, head2);

		System.out.println(intersect.val);

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.run(args);
	}
}