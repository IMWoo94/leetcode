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
		ListNode fast = head;
		ListNode slow = head;

		// fast 2칸씩 나아가고 slow 는 한칸씩
		// 이런식으로 fast 가 먼저 치고 나가면 패스트가 끝까지 간 경우 slow 는 중간에 위치한다.
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// 단 홀수개 인 경우에는 중간을 벗어나야 하기 때문에 느린 러너를 한칸 더 앞으로 가도록 처리
		// 팰린드롬을 찾는 경우 홀수 인 경우엔 중간값을 비교할 필요가 없기떄문이며, 중간 양 옆의 값을 확인하면 된다.
		if (fast.next != null) {
			slow = slow.next;
		}

		// 중간에 도달한 느린 러너를 역순으로 연결 리스트 생성
		ListNode rev = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = rev;
			rev = slow;
			slow = next;
		}

		// rev 리스트를 끝까지 이동하면서 비교
		while (rev != null) {
			if (rev.val != head.val) {
				return false;
			}
			rev = rev.next;
			head = head.next;
		}
		return true;
    }
}