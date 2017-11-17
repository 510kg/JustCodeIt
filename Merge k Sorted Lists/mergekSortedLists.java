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

	//Divide&Conquer
	public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
        	return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
    	if (start >= end) {
    		return lists[start];
    	}
    	int mid = start + (end - start) / 2;
    	ListNode left = mergeHelper(lists, start, mid);
    	ListNode right = mergeHelper(lists, mid + 1, end);
    	return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    //PriorityQueue
    public ListNode mergeKLists2(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
    		return null;
    	}

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
            	return l1.val - l2.val;
            }
        });

        for (ListNode node : lists) {
        	if (node != null) {
        	    heap.offer(node);
        	}
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!heap.isEmpty()) {
        	ListNode curr = heap.poll();
        	temp.next = curr;
        	temp = temp.next;
        	if (curr.next != null) {
        		heap.offer(curr.next);
        	}
        }

        return dummy.next;
    }

    //merge two by two, only for ArrayList
    public ListNode mergeKLists3(List<ListNode> lists) {
    	if (lists == null || lists.size() == 0) {
    		return null;
    	}
    	while (lists.size() > 1) {
    		List<ListNode> newLists = new ArrayList<>();
    		for (int i = 0; i < lists.size() - 1; i += 2) {
                ListNode l1 = lists.get(i);
                ListNode l2 = lists.get(i + 1);
                ListNode newL = mergeTwoLists(l1, l2);
                newLists.add(newL);
    		}
    		if (lists.size() % 2 == 1) {
    			newLists.add(lists.get(lists.size() - 1));
    		}

    		lists = newLists;
    	}
        return lists.get(0);
    }

    
    //for test
    public ListNode converter(int[] vals) {
    	if (vals == null || vals.length == 0) {
    		return null;
    	}
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

        int[] vals1 = new int[] {2, 3, 6, 7};
        int[] vals2 = new int[] {4, 4, 5, 5};
        int[] vals3 = new int[] {};

        ListNode n1 = solution.converter(vals1);
        ListNode n2 = solution.converter(vals2);
        ListNode n3 = solution.converter(vals3);
        ListNode n4 = solution.converter(vals1);
        ListNode n5 = solution.converter(vals2);
        ListNode n6 = solution.converter(vals3);

        ListNode[] l1 = new ListNode[] {n1, n2, n3};
        ListNode[] l2 = new ListNode[] {n4, n5, n6};

        ListNode r1 = solution.mergeKLists1(l1);
        ListNode r2 = solution.mergeKLists2(l2);

        while (r1 != null) {
        	System.out.println(r1.val);
        	r1 = r1.next;
        }

        System.out.println(";");

        while (r2 != null) {
        	System.out.println(r2.val);
        	r2 = r2.next;
        }
    }
}