class Solution {
    data class Point(var distance: Double, var point: IntArray)
    
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<Point>(compareBy { a -> a.distance })

        for (point in points) {
            val dis = point[0].toDouble() * point[0] + point[1].toDouble() * point[1]
            pq.add(Point(dis, point))
        }

        val answer: Array<IntArray> = Array(k) { IntArray(2) { 0 } }
        for (i in 0 until k) {
            answer[i] = pq.poll().point
        }

        return answer
    }
}