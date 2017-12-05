import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
	Solution() {}

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
            	break;
            }
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
    	ListNode nk = head;
    	for (int i = 0; i < k; i++) {
    		if (nk == null) {
    			return null;
    		}
    		nk = nk.next;
    	}

    	if (nk == null) {
    		return null;
    	}

    	ListNode n1 = head.next;
    	ListNode nkNext = nk.next;
    	ListNode curr = n1;
    	ListNode prev = null;
    	while (curr != nkNext) {
    		ListNode temp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = temp;
    	}

    	head.next = nk;
    	n1.next = nkNext;

    	return n1;
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

    public static void main(String[] args) {
    	Solution solution = new Solution();

    	int[] vals = new int[] {1, 2, 3, 4, 5, 6};
    	int k = 3;
    	ListNode node = solution.converter(vals);

    	ListNode result = solution.reverseKGroup(node, k);

    	while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}