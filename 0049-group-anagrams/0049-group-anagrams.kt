class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // 애너그램 보관 map
        val result: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (s in strs) {
            // 문자열 정렬
            val key = s.toCharArray().sorted().joinToString()

            // map key 등록
            result.getOrPut(key) { mutableListOf() }

            // null 아님
            result[key]!!.add(s)
        }

        return ArrayList<List<String>>(result.values)
    }
}