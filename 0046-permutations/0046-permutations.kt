import java.util.*

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(prevElements: MutableList<Int>, element: MutableList<Int>) {
            // 더 이상 요소가 없는 경우
            if (element.isEmpty()) {
                results.add(prevElements.stream().collect(Collectors.toList()))
            }

            for (e in element) {
                var nextElement = ArrayList(element)
                nextElement.remove(e)

                prevElements.add(e)
                dfs(prevElements, nextElement)
                prevElements.remove(e)
            }
        }

        val list = Arrays.stream(nums).boxed().collect(Collectors.toList())
        dfs(mutableListOf(), list)

        return results
    }
}