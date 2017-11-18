class Queue {
	int count;
	int firstIndex;
	int[] array;
	Queue() {
		firstIndex = 0;
		count = 0;
		array = new int[10];
	}

	public int peek() {
		if (count == 0) {
			return -1;
		} else {
			return array[firstIndex];
		}
	}

	public void enqueue(int x) {
		if (firstIndex + count < array.length) {
			array[firstIndex + count] = x;
			count++;
		} else {
			array = resize(array);
			array[firstIndex + count] = x;
			count++;
		}
	}

	public int dequeue() {
		if (count == 0) {
			return -1;
		} else {
			int res = array[firstIndex];
			array[firstIndex] = 0;
			firstIndex++;
			count--;
			return res;
		}
	}

	private int[] resize(int[] array) {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
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