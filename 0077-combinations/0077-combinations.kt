class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(element: LinkedList<Int>, start: Int, k: Int) {
            if (k == 0) {
                results.add(element.stream().collect(Collectors.toList()))
                return
            }

            // 현재 요소 이후 탐색
            for (i in start..n) {
                element.add(i)
                dfs(element, i + 1, k - 1)
                element.removeLast()
            }
        }

        dfs(LinkedList(), 1, k)
        return results
    }
}