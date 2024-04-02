class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
    // 투 포인터를 활용해서 풀이
    var left: Int
    var right: Int
    var sum: Int

    // 정렬
    nums.sort()
    var answer: MutableList<List<Int>> = mutableListOf()

    for ((i, num) in nums.withIndex()) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        left = i + 1
        right = nums.size - 1
        while (left < right) {
            sum = num + nums[right] + nums[left]
            if (sum > 0) {
                right--
            } else if (sum < 0) {
                left++
            } else {
                // 0 이 되는 정답의 경우
                answer.add(listOf(num, nums[left], nums[right]))

                // left, right 에 중복 원소 넘어가기
                while (left < right && nums[left] == nums[left + 1]) {
                    left++
                }

                while (left < right && nums[right] == nums[right - 1]) {
                    right--
                }

                left++
                right--
            }
        }
    }

    return answer
    }
}