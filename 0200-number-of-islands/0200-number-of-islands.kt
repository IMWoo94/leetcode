class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            // 현재 위치가 그리드 밖이거나, 물(0)인 경우 종료
            when {
                (i < 0) ||
                        (j < 0) ||
                        (i >= grid.size) ||
                        (j >= grid[i].size) ||
                        grid[i][j] == '0' ||
                        grid[i][j] == '#' -> return
            }
            // 육지를 방문의 표시로 '#' 처리
            grid[i][j] = '#'

            // 동서남북 방문
            dfs(i, j + 1)
            dfs(i, j - 1)
            dfs(i + 1, j)
            dfs(i - 1, j)
        }

        var count = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    count++
                }
            }
        }

        return count
    }
}