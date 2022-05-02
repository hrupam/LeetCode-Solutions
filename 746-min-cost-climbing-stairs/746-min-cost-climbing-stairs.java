class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        
        for(int i=2;i<=n;i++){
            int l=cost[i-1]+dp[i-1];
            int r=(int)1e9;
            if(i-2>=0) r=cost[i-2]+dp[i-2];

            dp[i]=Math.min(l,r);
        }
        
        return dp[n];
    }
}