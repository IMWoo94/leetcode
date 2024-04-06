class MyCircularQueue {
    
    int[] q;
	int front = 0;
	int rear = -1;
	int len = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

	public boolean enQueue(int value) {
		if (!this.isFull()) {
			this.rear = (this.rear + 1) % q.length;
			this.q[rear] = value;
			this.len++;
			return true;
		}

		return false;
	}

	public boolean deQueue() {
		if (!this.isEmpty()) {
			int value = q[this.front];
			this.front = (this.front + 1) % q.length;
			this.len--;
			return true;
		}
		return false;
	}

	public int Front() {
		if (!this.isEmpty()) {
			return q[this.front];
		}
		return -1;
	}

	public int Rear() {
		if (!this.isEmpty() && rear != -1) {
			return q[this.rear];
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.len == 0;
	}

	public boolean isFull() {
		return this.len == q.length;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */