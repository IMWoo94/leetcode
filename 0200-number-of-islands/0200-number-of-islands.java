class Solution {
    public int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(i, j, grid);
					count++;
				}
			}
		}

		return count;
	}

	public void dfs(int i, int j, char[][] grid) {
		// i, j 범위가 그리드의 범위를 벗어나는 경우 return
        // i, j 의 땅의 값이 물인 경우 return
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
			return;
		
        if(grid[i][j] == '#') return;

		// 방문한 육지에 대해서 '1', '0' 이 아닌 값으로 대체
		grid[i][j] = '#';
		// 동서남북으로 이어져 있는 육지 찾아가기
		// 동
		dfs(i, j + 1, grid);
		// 서
		dfs(i, j - 1, grid);
		// 남
		dfs(i + 1, j, grid);
		// 북
		dfs(i - 1, j, grid);
	}
}