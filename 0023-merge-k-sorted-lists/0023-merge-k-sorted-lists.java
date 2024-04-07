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
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode answer = new ListNode(0);
		ListNode curr = answer;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		int len = lists.length;
		for (int i = 0; i < len; i++) {
			ListNode node = lists[i];
			while (node != null) {
				priorityQueue.add(node.val);
				node = node.next;
			}
		}

		while (!priorityQueue.isEmpty()) {
			curr.next = new ListNode(priorityQueue.poll());
			curr = curr.next;
		}

		return answer.next;
    }
}