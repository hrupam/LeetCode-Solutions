class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        dfs(sr, sc, color, image[sr][sc], image, new boolean[m][n], m, n);

        return image;
    }

    private void dfs(int i, int j, int color, int iniCol, int[][] image, boolean[][] vis, int m, int n) {
        image[i][j] = color;
        vis[i][j] = true;

        int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int[] d : deviations) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj] && image[ni][nj] == iniCol) {
                dfs(ni, nj, color, iniCol, image, vis, m, n);
            }
        }
    }
}
