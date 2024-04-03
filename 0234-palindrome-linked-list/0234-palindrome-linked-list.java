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
		Deque<Integer> deque = new ArrayDeque<>();
		while (head != null) {
			deque.add(head.val);
			head = head.next;
		}

		// 비어 있거나, 1개 이하가 될 때 까지 비교
		while (!deque.isEmpty() && deque.size() > 1) {
			if (deque.pollLast() != deque.poll()) {
				return false;
			}
		}
		return true;
    }
}