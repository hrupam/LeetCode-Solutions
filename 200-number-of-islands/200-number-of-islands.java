class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int ctr = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(i, j, vis, grid, m, n);
                    ctr++;
                }
            }
        }
        return ctr;
    }

    private void bfs(int i, int j, boolean[][] vis, char[][] grid, int m, int n) {
        Queue<Pair> queue = new LinkedList<>();

        int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        vis[i][j] = true;
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            int curI = tmp.first;
            int curJ = tmp.second;
            for (int[] d : deviations) {
                int nI = curI + d[0];
                int nJ = curJ + d[1];

                if (nI >= 0 && nI < m && nJ >= 0 && nJ < n && grid[nI][nJ] == '1' && !vis[nI][nJ]) {
                    vis[nI][nJ] = true;
                    queue.add(new Pair(nI, nJ));
                }
            }
        }
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
