class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s, n, new HashSet<>(wordDict), dp) == 1;
    }

    private int f(int i, String s, int n, Set<String> dict, int[] dp) {
        if (i == n) return 1;
        if (dp[i] != -1) return dp[i];

        for (int j = i; j < n; j++) {
            if (dict.contains(s.substring(i, j + 1))) {
                if (f(j + 1, s, n, dict, dp) == 1) return dp[i] = 1;
            }
        }
        return dp[i] = 0;
    }
}
