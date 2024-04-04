/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var root = ListNode(0)
        var node = root

        var node1 = l1
        var node2 = l2

        var sum: Int
        var remainder: Int
        var carry = 0
        while (node1 != null || node2 != null || carry != 0) {
            sum = 0
            if (node1 != null) {
                sum += node1.`val`
                node1 = node1.next
            }
            if (node2 != null) {
                sum += node2.`val`
                node2 = node2.next
            }

            remainder = (sum + carry) % 10
            carry = (sum + carry) / 10

            node.next = ListNode(remainder)
            node = node.next!!
        }

        return root.next
    }
}