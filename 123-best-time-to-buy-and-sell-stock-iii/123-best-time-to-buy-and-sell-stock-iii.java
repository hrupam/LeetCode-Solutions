class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int canbuy=0;canbuy<=1;canbuy++){
                for(int tran=1;tran<3;tran++){
                    
                    
                    int profit=0;
                    if(canbuy==1)
                        profit= Math.max(-prices[ind] + dp[ind+1][0][tran], dp[ind+1][1][tran]);
                    
                    else
                        profit=Math.max(prices[ind]+ dp[ind+1][1][tran-1], dp[ind+1][0][tran]);
                    
                    dp[ind][canbuy][tran]=profit;
                        
                    
                }
            }
        }
        
        return dp[0][1][2];
        
        
    }
}