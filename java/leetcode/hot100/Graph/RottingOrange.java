package hot100.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> rotten = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) rotten.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int minute = -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            while (size-- > 0) {
                int[] pos = rotten.poll();
                int i = pos[0], j = pos[1];
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        rotten.add(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
