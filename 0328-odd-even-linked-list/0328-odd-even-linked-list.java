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
    public ListNode oddEvenList(ListNode head) {
        // 예외 처리
		if (head == null) {
			return null;
		}
        
		ListNode odd = head;
		ListNode even = head.next;
		// 짝수 첫번째노드
		ListNode evenHead = even;

		// 반복하면서 홀짝 처리
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			// 홀짝 한칸 씩 진행
			odd = odd.next;
			even = even.next;
		}

		// 홀수 노드 마지막을 짝수 헤드와 연결
		odd.next = evenHead;
		return head;
    }
}