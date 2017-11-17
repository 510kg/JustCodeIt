import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

class Solution {
    Solution() {}

	public ListNode mergeTwoListsWihoutDuplicates(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode newHead = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val){
				if (newHead == dummy || newHead.val != l1.val) {
					newHead.next = l1;
					newHead = newHead.next;
				}
				l1 = l1.next;
			} else {
				if (newHead == dummy || newHead.val != l2.val) {
					newHead.next = l2;
					newHead = newHead.next;
				}
				l2 = l2.next;
			}
		}
		
		while (l1 != null) {
			if (newHead == dummy || newHead.val != l1.val) {
				newHead.next = l1;
				newHead = newHead.next;
			}
			l1 = l1.next;
		}
		while (l2 != null) {
			if (newHead == dummy || newHead.val != l2.val) {
				newHead.next = l2;
				newHead = newHead.next;
			}
			l2 = l2.next;
		}
		
		newHead.next = null;
		
		return dummy.next;
	}

	public ListNode converter(int[] vals) {
		ListNode origin = new ListNode(vals[0]);
		ListNode temp = origin;
		for (int i = 1; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		return origin;
	}

    public static void main(String args[]) {
    	Solution solution = new Solution();

    	int[] vals1 = new int[] {1, 2, 2, 3, 3, 5};
    	int[] vals2 = new int[] {3, 3, 4, 5, 6, 6, 6};
		
		ListNode n1 = solution.converter(vals1);
		ListNode n2 = solution.converter(vals2);
		
		ListNode head = solution.mergeTwoListsWihoutDuplicates(n1, n2);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
