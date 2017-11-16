class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    	this.val = x;
    	next = null;
    }
}

class Solution {
	Solution() {}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
        	} else {
        		temp.next = l2;
        		l2 = l2.next;
        	}
        	temp = temp.next;
        }

        if (l1 != null) {
        	temp.next = l1;
        }
        if (l2 != null) {
        	temp.next = l2;
        }

        return dummy.next;
	}

	public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(11);
        ListNode n6 = new ListNode(15);
        ListNode n7 = new ListNode(1);
        ListNode n8 = new ListNode(1);
        ListNode n9 = new ListNode(12);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n7.next = n8;
        n8.next = n9;

        ListNode r1 = solution.mergeTwoLists(n1, n7);

        while (r1 != null) {
        	System.out.println(r1.val);
        	r1 = r1.next;
        }
	}
}