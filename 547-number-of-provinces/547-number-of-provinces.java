class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                f(i, isConnected, vis, n);
            }
        }
        return provinces;
    }

    private static void f(int i, int[][] isCon, boolean[] vis, int n) {
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (i != j && isCon[i][j] == 1 && !vis[j]) f(j, isCon, vis, n);
        }
    }
}
