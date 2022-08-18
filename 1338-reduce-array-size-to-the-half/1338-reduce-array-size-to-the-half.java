class Solution {

    public int minSetSize(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);

        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies, (a, b) -> b - a);

        int ctr = 0;
        int len = n;
        for (int f : frequencies) {
            len -= f;
            ctr++;
            if (len <= n / 2) return ctr;
        }
        return ctr;
    }
}
