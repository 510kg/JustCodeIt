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

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(1);

        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode result = solution.addTwoNumbers(node1, node6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}