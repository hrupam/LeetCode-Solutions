class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        
        int[][] dp=new int[n][days[n-1]+30];
        for(int[] x:dp) Arrays.fill(x,-1);
        
        return f(0,0,n,days,costs,dp);
    }
    
    private static int f(int i, int deadline, int n, int[] days, int[] costs, int[][] dp){
        if(i==n) return 0;
        if(dp[i][deadline]!=-1) return dp[i][deadline];
        
        if(deadline>=days[i]) return dp[i][deadline]=f(i+1,deadline,n,days,costs,dp);
        
        int mini=(int)1e9;
        for(int j=0;j<=2;j++){
            int val=1;
            if(j==1) val=7;
            else if(j==2) val=30;
            
            int cost=costs[j]+f(i+1,days[i]+val-1,n,days,costs,dp);
            mini=Math.min(mini, cost);
        }
        return dp[i][deadline]=mini;
    }
}