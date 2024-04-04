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
		return reverse(head, null);
	}

	public ListNode reverse(ListNode node, ListNode prev) {
		// 현재 노드가 null 이면 return
		if (node == null)
			return prev;

		// 현재 노드의 다음 노드 미리 지정
		ListNode next = node.next;
		// 현재 노드의 다음으로 이전 노드 지정
		node.next = prev;

		return reverse(next, node);
	}
}