class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] x : dp) Arrays.fill(x, -1);

        int res = f(0, 1, prices, n, dp);
        return res;
    }
    
    private static int f(int ind, int canBuy, int[] arr, int n, int[][] dp) {
        if (ind >= n) return 0;
        if (dp[ind][canBuy] != -1) return dp[ind][canBuy];

        int profit = 0;

        //can buy
        if (canBuy == 1)
            profit = Math.max(-arr[ind] + f(ind + 1, 0, arr, n, dp), f(ind + 1, 1, arr, n, dp));

            //cannot buy -> sell
        else
            profit = Math.max(arr[ind] + f(ind + 2, 1, arr, n, dp), f(ind + 1, 0, arr, n, dp));

        return dp[ind][canBuy] = profit;
    }
}