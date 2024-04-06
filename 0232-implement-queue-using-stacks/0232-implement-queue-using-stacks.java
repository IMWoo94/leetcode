class MyQueue {

    // 삽입 스택
	Deque<Integer> input = new ArrayDeque<>();
	// 추출 스택
	Deque<Integer> output = new ArrayDeque<>();
    
    public MyQueue() {
        
    }

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		peek();

		return output.pop();
	}

	public int peek() {
		// 추출 스택에 저장된 게 없다면 진행
		if (output.isEmpty()) {
			// 삽입 스택이 빌떄 까지 진행
			while (!input.isEmpty()) {
				// 삽입 스택의 값을 추출 스택에 등록 ( 이때 역순으로 등록 되면서 처음에 나와야 하는 값이 Stack 상단에 존재하게 된다.)
				output.push(input.pop());
			}
		}
		// 가장 나중에 삽입된 결과 조회
		return output.peek();
	}

	public boolean empty() {
		return output.isEmpty() && input.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */