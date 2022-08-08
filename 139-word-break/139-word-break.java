class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];

        Set<String> dict = new HashSet<>(wordDict);

        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (dict.contains(s.substring(i, j + 1))) {
                    if (dp[j + 1] == 1) dp[i] = 1;
                }
            }
        }
        return dp[0] == 1;
    }
}
