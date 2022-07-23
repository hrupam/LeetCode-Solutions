class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];

        Deque<Integer> stack = new ArrayDeque<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new LinkedList<>());
        for (int[] arr : prerequisites) adj.get(arr[1]).add(arr[0]);

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                //if cycle exists, no topological ordering
                if (f(i, vis, dfsVis, stack, adj)) return new int[0];
            }
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while (stack.size() != 0) arr[i++] = stack.pollFirst();

        return arr;
    }

    //returns true if cycle exists + maintains topological ordering
    private static boolean f(int i, boolean[] vis, boolean[] dfsVis, Deque<Integer> stack, List<List<Integer>> adj) {
        vis[i] = dfsVis[i] = true;
        for (int j : adj.get(i)) {
            if (!vis[j]) {
                if (f(j, vis, dfsVis, stack, adj)) return true;
            } else if (dfsVis[j]) return true;
        }
        stack.offerFirst(i);
        dfsVis[i] = false;
        return false;
    }
}
