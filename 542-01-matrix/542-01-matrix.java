class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];
        Deque<Pair> Q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    Q.offerLast(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!Q.isEmpty()) {
            Pair p = Q.pollFirst();
            int i = p.i;
            int j = p.j;
            int dt = p.dist;
            dist[i][j] = dt;

            for (int[] d : deviations) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj]) {
                    Q.offerLast(new Pair(ni, nj, dt + 1));
                    vis[ni][nj] = true;
                }
            }
        }
        return dist;
    }
}

class Pair {
    int i;
    int j;
    int dist;

    public Pair(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.dist = d;
    }
}
