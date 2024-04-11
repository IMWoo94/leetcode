class Solution {
    public int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					iterativeDFS(i, j, grid);
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
    
	public void iterativeDFS(int i, int j, char[][] grid) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {i, j});

		while (!stack.isEmpty()) {
			int[] xy = stack.poll();
			i = xy[0];
			j = xy[1];
			// 그리드 범위를 넘어가지 않고 현재 위치가 육지라면 육지로 변환
			if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == '1') {
				grid[i][j] = '#';
				// 동서남북 stack 쌓기
				stack.push(new int[] {i, j + 1});
				stack.push(new int[] {i, j - 1});
				stack.push(new int[] {i + 1, j});
				stack.push(new int[] {i - 1, j});
			}
		}
	}
}