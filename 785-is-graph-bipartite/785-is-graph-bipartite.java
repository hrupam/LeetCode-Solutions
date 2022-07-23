class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!f(i, color, graph)) return false;
            }
        }
        return true;
    }

    private static boolean f(int i, int[] color, int[][] adj) {
        if (color[i] == -1) color[i] = 0;

        for (int j : adj[i]) {
            if (color[j] == -1) {
                color[j] = 1 - color[i];
                if (!f(j, color, adj)) return false;
            } else if (color[j] == color[i]) return false;
        }
        return true;
    }
}
