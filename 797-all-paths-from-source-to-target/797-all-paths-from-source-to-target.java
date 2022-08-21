class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new LinkedList<>();
        f(0, n, graph, new ArrayList<>(), list);
        return list;
    }

    private void f(int i, int n, int[][] graph, List<Integer> sublist, List<List<Integer>> list) {
        if (i == n - 1) {
            sublist.add(n - 1);
            list.add(new ArrayList<>(sublist));
            sublist.remove(sublist.size() - 1);
            return;
        }
        for (int j : graph[i]) {
            sublist.add(i);
            f(j, n, graph, sublist, list);
            sublist.remove(sublist.size() - 1);
        }
    }
}
