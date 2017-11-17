class ListNode {
    int val;
    ListNode next;
    ListNode(int i) {
        this.val = i;
        this.next = null;
    }
}

class Solution {
    public Solution() {}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
        sum /= 10;//care about the carry directly when start calculating everytime
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }
        if (sum/10 != 0) {
            temp.next = new ListNode(1);
        }
        return head.next;
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

        int[] vals1 = new int[] {3, 0, 8, 9, 1};
        int[] vals2 = new int[] {7, 2, 3, 3};

        ListNode n1 = solution.converter(vals1);
        ListNode n2 = solution.converter(vals2);

        ListNode result = solution.addTwoNumbers(n1, n2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}