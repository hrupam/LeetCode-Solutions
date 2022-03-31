class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        int[] arr = prices;


        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {

                int profit = 0;

                //can buy
                if (canBuy == 1)
                    profit = Math.max(-arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);

                    //cannot buy -> sell
                else
                    profit = Math.max(arr[ind] + dp[ind + 2][1], dp[ind + 1][0]);

                dp[ind][canBuy] = profit;
            }
        }

        return dp[0][1];
    }
    
}