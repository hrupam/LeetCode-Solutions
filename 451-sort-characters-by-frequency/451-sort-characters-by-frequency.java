class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        String res = "";
        for (Map.Entry<Character, Integer> e : list) {
            int t = e.getValue();
            while (t-- != 0) res += e.getKey();
        }

        return res;
    }
}
