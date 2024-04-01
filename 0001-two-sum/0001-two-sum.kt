class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()

        // for 문 하나로 map, target 찾기
        for ((i, num) in nums.withIndex()) {
            var key = target - num
            if (map.containsKey(key)) {
                return intArrayOf(map.getOrDefault(key, 0), i)
            }
            map.put(num, i)
        }

        return intArrayOf(0, 0)
    }
}