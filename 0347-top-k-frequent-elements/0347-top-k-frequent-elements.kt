class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var frequencyMap: MutableMap<Int, Int> = mutableMapOf()
        for (num in nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1)
        }

        var pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray -> b[1] - a[1] }
        for (key in frequencyMap.keys) {
            pq.add(intArrayOf(key, frequencyMap.get(key)!!))
        }

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = pq.poll()[0]
        }

        return result
    }
}