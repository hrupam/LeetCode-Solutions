class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        int[] arr = prices;

        dp[n][0] = dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {

                int profit = 0;

                if (canBuy == 1)
                    dp[ind][1] = Math.max(-arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);

                else
                    dp[ind][0] = Math.max((arr[ind] - fee) + dp[ind + 1][1], dp[ind + 1][0]);
            }
        }

        return dp[0][1];
    }
}