class Solution {

    public boolean isHappy(int n) {
        return f(n, new HashSet<>());
    }

    private boolean f(int n, Set<Integer> set) {
        int s = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            s += d * d;
        }

        if (s == 1) return true;
        if (set.contains(s)) return false;
        set.add(s);
        return f(s, set);
    }
}
