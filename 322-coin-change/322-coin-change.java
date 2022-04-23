class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        
        int[][] dp=new int[n][amount+1];
        
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0) dp[0][amt]=amt/coins[0];
            else dp[0][amt]=(int)1e9;
        }
        
        for(int i=1;i<n;i++){
            for(int amt=1;amt<=amount;amt++){
                
                int p=(int)1e9;
                if(coins[i]<=amt) p=1 + dp[i][amt-coins[i]];

                int np=dp[i-1][amt];

                dp[i][amt]=Math.min(p,np);
            }
        }
        
        int ans=dp[n-1][amount];
        
        if(ans>=(int)1e9) return -1;
        return ans;
    }
}