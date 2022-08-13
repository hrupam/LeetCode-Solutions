class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int freshCtr = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new Pair(i, j, 0));
                if (grid[i][j] == 1) freshCtr++;
            }
        }
        
        int minutes = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int i = p.first;
            int j = p.second;
            int time = p.time;
            minutes = Math.max(minutes, time);

            int[][] deviations = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            for (int[] d : deviations) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                    queue.add(new Pair(ni, nj, time + 1));
                    grid[ni][nj] = 2;
                    --freshCtr;
                }
            }
        }
        return freshCtr == 0 ? minutes : -1;
    }
}

class Pair {
    int first;
    int second;
    int time;

    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
