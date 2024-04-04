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
    public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode node = head;

		// 노드 끝으로 이동 반복 순회
		while (node != null) {
			// 현재 노드의 다음 노드를 지정
			ListNode next = node.next;

			// 현재 노드의 다음으로 이전 노드를 지정
			node.next = prev;

			// 이전 노드는 현재 노드로 지정
			prev = node;

			// 미리 지정한 다음 노드를 현재 노드로 변경
			node = next;
		}

		return prev;
	}
}