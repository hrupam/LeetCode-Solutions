class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
    
    private static int f(int i,int[] dp){
        if(i==0) return 1;
        if(i==1) return 1;
        if(dp[i]!=-1) return dp[i];
        
        int l=f(i-1,dp);
        int r=f(i-2,dp);
        
        return dp[i]=l+r;
    }
}