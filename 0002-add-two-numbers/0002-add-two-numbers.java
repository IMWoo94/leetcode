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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode node = root;

		int remainder = 0;
		int carry = 0;
		int sum = 0;
		while (l1 != null || l2 != null || carry != 0) {
			sum = 0;

			// 첫번째 연결 리스트 합산
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			// 두번째 연결 리스트 합산
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			// 노드의 값으로 사용할 올림 처리 나머지 계산
			remainder = (sum + carry) % 10;
			// 올림 값
			carry = (sum + carry) / 10;

			node.next = new ListNode(remainder);

			node = node.next;
		}

		return root.next;
	}

}