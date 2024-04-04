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
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode reversedL1 = reverse(l1);
		ListNode reversedL2 = reverse(l2);

		// 임의 정밀도 정수형으로 변환하여 더하기 연산 진행
		BigInteger sum = toBigInt(reversedL1).add(toBigInt(reversedL2));

		// 결과를 다시 역순으로
		return toReversedLinkedList(sum);

	}

	// 연결 리스트 역순 정렬
	public ListNode reverse(ListNode root) {
		ListNode node = root;
		ListNode prev = null;

		while (node != null) {
			ListNode next = node.next;
			node.next = prev;

			prev = node;
			node = next;
		}
		return prev;
	}

	// 연결 리스트의 값 이어서 정수로 변환
	public BigInteger toBigInt(ListNode node) {
		String val = "";

		while (node != null) {
			val += node.val;
			node = node.next;
		}
		return new BigInteger(val);
	}

	// 주어진 정수를 연결리스트 역순으로 처리
	public ListNode toReversedLinkedList(BigInteger val) {
		ListNode prev = null;
		ListNode node = null;

		// 정수형을 문자로 바꾼 다음 문자 배열로 전환하여 한 글자씩 순회
		for (char c : String.valueOf(val).toCharArray()) {
			// 한글자씩 숫자로 변환하여 노드 생성
			node = new ListNode(Character.getNumericValue(c));
			// 최종 결과는 뒤집어야 하므로 현재 노드의 다음으로 이전 노드 지전
			node.next = prev;
			// 이전 노드는 현재 노드 지정
			prev = node;
		}

		return node;
	}

}