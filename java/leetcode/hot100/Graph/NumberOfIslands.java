package hot100.Graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    removeIsland(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void removeIsland(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i, j + 1);
        removeIsland(grid, i, j - 1);
    }
}
