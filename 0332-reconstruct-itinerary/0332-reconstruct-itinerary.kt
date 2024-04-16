import java.util.ArrayDeque

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
       val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        // 여행 일정은 from -> to 형태의 그래프로 구성
        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue<String>())
            fromToMap.get(ticket[0])!!.add(ticket[1])
        }

        val results: MutableList<String> = LinkedList()
        val stack: Deque<String> = ArrayDeque()
        // 출발지 삽입
        stack.push("JFK")
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.peekFirst()) && !fromToMap.get(stack.peekFirst())!!.isEmpty()) {
                stack.push(fromToMap.get(stack.peekFirst())!!.poll())
            }

            results.add(0, stack.poll())
        }

        return results
    }
}