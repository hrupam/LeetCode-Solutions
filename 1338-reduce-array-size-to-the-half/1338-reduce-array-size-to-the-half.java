class Solution {

    public int minSetSize(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        int ctr = 0;
        int len = n;
        for (Map.Entry<Integer, Integer> e : list) {
            len -= e.getValue();
            ctr++;
            if (len <= n / 2) return ctr;
        }
        return ctr;
    }
}
