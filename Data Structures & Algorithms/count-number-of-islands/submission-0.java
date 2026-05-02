class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean [][]visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0;j < cols; j++) {
                visited[i][j] = false;
            }
        }

        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    this.dfs(grid, visited, i, j, rows, cols);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        visited[i][j] = true;

        int []r = {-1, 1, 0, 0};
        int []c = {0, 0, -1, 1};

        for (int idx = 0; idx < 4; idx++) {
            int new_r = i + r[idx];
            int new_c = j + c[idx];

            if (this.isValid(grid, visited, new_r, new_c, rows, cols)) {
                this.dfs(grid, visited, new_r, new_c, rows, cols);
            }
        }
    }

    private boolean isValid(char[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
        return (r >= 0 && r < rows) && (c >= 0 && c < cols) && grid[r][c] == '1' && !visited[r][c];
    }
}
