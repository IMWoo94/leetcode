class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var set: MutableSet<Char> = HashSet()
        var count = 0

        for (j in jewels.toCharArray()) {
            set.add(j)
        }

        for (s in stones.toCharArray()) {
            if (set.contains(s)) count++
        }
        return count
    }
}