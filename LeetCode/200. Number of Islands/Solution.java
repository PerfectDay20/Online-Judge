public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] cs, int r, int c) {
        if (cs[r][c] == '1') {
            cs[r][c] = '2';
            if (r > 0) {
                bfs(cs, r - 1, c);
            }
            if (c > 0) {
                bfs(cs, r, c - 1);
            }
            if (r < cs.length - 1) {
                bfs(cs, r + 1, c);
            }
            if (c < cs[0].length - 1) {
                bfs(cs, r, c + 1);
            }
        }
    }
}