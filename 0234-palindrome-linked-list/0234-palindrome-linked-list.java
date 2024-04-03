/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
		// 얇은 복사
		ListNode node = head;
		// 스택을 아래와 같이 선언하는 것은 좋지 않다.
		// 공유 자원에 대한 처리에 의해서 synchronized 선언이 되어 있으므로 성능이 좋을 수 없다.
		Stack<Integer> stack = new Stack<>();

		// 1. stack 에 연결 리스트 값 넣기
		while (node != null) {
			stack.push(node.val);
			// 다음 노드 정보로 이동
			node = node.next;
		}

		// head 를 처음부터 비교
		while (head != null) {
			// 여기서 헤드를 마지막 부터 비교하는 것이 아닌 처음 부터 비교를 하는 이유는
			// stack 의 LIFO 성질에 의해서 마지막에 들어온 것이 먼저 나오게 된다.
			// 그렇기 때문에 1 번 작업의 내용물을 꺼내면 뒤에서 부터 값이 나오게 된다.
			if (head.val != stack.pop()) {
				return false;
			}
			head = head.next;
		}

		return true;
    }
}