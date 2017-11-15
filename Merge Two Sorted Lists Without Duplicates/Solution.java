import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class Solution {
	public static ListNode mergeTwoListsWihoutDuplicates(ListNode l1, ListNode l2) {
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
}