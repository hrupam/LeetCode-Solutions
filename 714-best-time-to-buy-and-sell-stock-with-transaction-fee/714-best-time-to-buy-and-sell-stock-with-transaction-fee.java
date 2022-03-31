class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        int[] arr = prices;

        dp[n][0] = dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {

            dp[ind][1] = Math.max(-arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);

            dp[ind][0] = Math.max((arr[ind] - fee) + dp[ind + 1][1], dp[ind + 1][0]);
            
        }
        

        return dp[0][1];
    }
}