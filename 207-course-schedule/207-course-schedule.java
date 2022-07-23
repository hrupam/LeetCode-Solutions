class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new LinkedList<>());
        for (int[] arr : prerequisites) adj.get(arr[1]).add(arr[0]);

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) if (f(i, vis, dfsVis, adj)) return false;
        }
        return true;
    }

    //Cycle detection using DFS
    private static boolean f(int i, boolean[] vis, boolean[] dfsVis, List<List<Integer>> adj) {
        vis[i] = dfsVis[i] = true;
        for (int j : adj.get(i)) {
            if (!vis[j]) {
                if (f(j, vis, dfsVis, adj)) return true;
            } else if (dfsVis[j]) return true;
        }
        dfsVis[i] = false;
        return false;
    }
}
