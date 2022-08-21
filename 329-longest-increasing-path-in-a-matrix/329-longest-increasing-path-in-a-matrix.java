class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dp = new int[m][n];
        for (int[] x : dp) Arrays.fill(x, -1);

        int maxi = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxi = Math.max(maxi, 1 + f(i, j, matrix, m, n, vis, dp));
            }
        }
        return maxi;
    }

    private int f(int i, int j, int[][] matrix, int m, int n, boolean[][] vis, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];

        int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int maxi = 0;
        for (int[] d : deviations) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j] && !vis[ni][nj]) {
                vis[i][j] = true;
                maxi = Math.max(maxi, 1 + f(ni, nj, matrix, m, n, vis, dp));
                vis[i][j] = false;
            }
        }
        return dp[i][j] = maxi;
    }
}
