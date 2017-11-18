class Queue {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}

	int count;
	ListNode first;
	ListNode last;
	public Queue() {
		first = null;
		last = null;
	}

	public int peek() {
		if (count == 0) {
			return -1;
		} else {
			return first.val;
		}
	}

	public void enqueue(int x) {
		ListNode node = new ListNode(x);
		if (count == 0) {
			first = node;
			last = node;
			count++;
		} else {
			last.next = node;
			last = last.next;
			count++;
		}
	}

	public int dequeue() {
		if (count == 0) {
			return -1;
		} else {
			int res = first.val;
			first = first.next;
			count--;
			if (count == 0) {
				last = null;
			}
			return res;
		}
	}


	public static void main(String[] args) {
		Queue queue = new Queue();

		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}