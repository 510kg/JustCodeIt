class Stack {
	int count;
	int[] array;
	Stack() {
		count = 0;
		array = new int[10];
	}

	public int peek() {
		if (count == 0) {
			return -1;
		} else {
			return array[count - 1];
		}
	}

	public void push(int x) {
		if (count < array.length) {
			array[count++] = x;
		} else {
			array = resize(array);
			array[count++] = x;
		}
	}

	public int pop() {
		if (count == 0) {
			return -1;
		} else {
			int res = array[count - 1];
			array[count - 1] = 0;
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
		Stack stack = new Stack();

		stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        stack.pop();
        System.out.println(stack.peek());
	}
}