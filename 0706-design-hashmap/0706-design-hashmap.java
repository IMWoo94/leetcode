class MyHashMap {
    
    Node[] nodes = new Node[1000000];

    public MyHashMap() {
        
    }
    
	public void put(int key, int value) {
		// 해시 함수를 사용하기 보단 간단하게 버킷의 총 갯수로 나머지 처리
		int index = key % nodes.length;
		if (nodes[index] == null) {
			nodes[index] = new Node(key, value);
		}

		// 충돌이 난다면
		Node node = nodes[index];
		while (node != null) {
			if (node.key == key) {
				node.value = value;
				return;
			}

			if (node.next == null) {
				break;
			}
			node = node.next;
		}
		node.next = new Node(key, value);

	}

	public int get(int key) {
		int index = key % nodes.length;
		if (nodes[index] == null) {
			return -1;
		}

		Node node = nodes[index];
		while (node != null) {
			if (node.key == key) {
				return node.value;
			}

			node = node.next;
		}

		return -1;
	}

	public void remove(int key) {
		int index = key % nodes.length;
		if (nodes[index] == null) {
			return;
		}

		Node node = nodes[index];
		if (node.key == key) {
			if (node.next == null)
				nodes[index] = null;
			else
				nodes[index] = node.next;
		}

		Node prev = node;
		while (node != null) {
			if (node.key == key) {
				prev.next = node.next;
				return;
			}
			prev = node;
			node = node.next;
		}
	}

	// 개별 체이닝 방식을 사용하기 위해서 node 생성 연결리스트
	static class Node {
		int key;
		int value;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */