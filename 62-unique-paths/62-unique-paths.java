class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] x : dp) Arrays.fill(x, -1);

        return f(0, 0, m, n, dp);
    }

    private int f(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = f(i, j + 1, m, n, dp) + f(i + 1, j, m, n, dp);
    }
}
