class MyStack {
Queue<Integer> queue = new LinkedList<>();
    
    public MyStack() {
        
    }
    
	public void push(int x) {
		// 값을 등록한다.
		// Queue 에 값을 등록하면 맨뒤에 등록이 된다.
		queue.add(x);

		// Queue 에서 마지막에 등록한 값을 가장 먼저 가져오기 위해서는
		// 신규 등록 x 를 Queue 의 앞으로 옮겨주면 된다.
		// 아래와 같이 반복문을 돌리면 x 값을 제외하고 queue 에 들어있는 값이 x 바로 뒤로 들어가게된다.
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.remove());
		}
	}

	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.size() == 0;
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */