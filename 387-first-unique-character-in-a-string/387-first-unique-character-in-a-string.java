class Solution {

    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Pair> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.get(c).count += 1; else map.put(c, new Pair(1, i));
        }

        for (Pair p : map.values()) if (p.count == 1) return p.firstIndex;

        return -1;
    }
}

class Pair {
    int count;
    int firstIndex;

    public Pair(int count, int firstIndex) {
        this.count = count;
        this.firstIndex = firstIndex;
    }
}
