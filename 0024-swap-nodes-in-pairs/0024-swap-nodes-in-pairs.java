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
    public ListNode swapPairs(ListNode head) {
		// 값을 계산할 임시 노드 생성
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode node = root;

		while (node.next != null && node.next.next != null) {
			ListNode a = node.next;
			ListNode b = node.next.next;

			a.next = b.next;
			node.next = b;
			node.next.next = a;

			node = node.next.next;
		}

		return root.next;
    }
}