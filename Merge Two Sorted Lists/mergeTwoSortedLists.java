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
        
        int[] vals1 = new int[] {0, 3, 7, 8, 11, 15};
        int[] vals2 = new int[] {1, 1, 12};

        ListNode n1 = solution.converter(vals1);
        ListNode n2 = solution.converter(vals2);

        ListNode r1 = solution.mergeTwoLists(n1, n2);

        while (r1 != null) {
        	System.out.println(r1.val);
        	r1 = r1.next;
        }
	}
}