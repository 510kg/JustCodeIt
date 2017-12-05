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

	

	private ListNode converter(int[] vals) {
		ListNode head = new ListNode(vals[0]);
		ListNoe curr = head;
		for (int i = 1; i < vals.length; i++) {
			curr.next = new ListNode(vals[i]);
			curr = curr.next;
		}
	} 

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}