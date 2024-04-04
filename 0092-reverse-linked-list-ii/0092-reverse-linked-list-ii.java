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
    public ListNode reverseBetween(ListNode head, int left, int right) {
		// 예외 처리
		if (head == null) {
			return null;
		}
		ListNode root = new ListNode(0);
		root.next = head;

		ListNode start = root;
		// left 만큼 이동
		for (int i = 0; i < left - 1; i++) {
			start = start.next;
		}
		ListNode end = start.next;

		for (int i = 0; i < right - left; i++) {
			ListNode temp = start.next;
			start.next = end.next;
			end.next = end.next.next;
			start.next.next = temp;
		}

		return root.next;
    }
}