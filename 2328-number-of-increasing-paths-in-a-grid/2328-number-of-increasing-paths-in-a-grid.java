class Solution {
    int mod = (int) 1e9 + 7;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dp = new int[m][n];
        for (int[] x : dp) Arrays.fill(x, -1);

        int ctr = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ctr = (ctr + (1 + f(i, j, grid, m, n, vis, dp))) % mod;
            }
        }
        return ctr;
    }

    private int f(int i, int j, int[][] grid, int m, int n, boolean[][] vis, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];

        int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int ctr = 0;
        for (int[] d : deviations) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] > grid[i][j] && !vis[ni][nj]) {
                vis[i][j] = true;
                ctr = (ctr + (1 + f(ni, nj, grid, m, n, vis, dp))) % mod;
                vis[i][j] = false;
            }
        }
        return dp[i][j] = ctr;
    }
}
