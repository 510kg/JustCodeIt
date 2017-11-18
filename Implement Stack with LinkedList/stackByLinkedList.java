class Stack {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
        }
    }

    int count;
    ListNode head;
    public Stack() {
        count = 0;
        head = null;
    }

    public int peek() {
        if (count == 0) {
            return -1;
        } else {
            return head.val;
        }
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
        count++;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        } else {
            int res = head.val;
            head = head.next;
            count--;
            return res;
        }
    }

	public static void main(String[] args) {
		Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        stack.pop();
        System.out.println(stack.peek());
	}
}