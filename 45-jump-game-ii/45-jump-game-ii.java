class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,nums,n,dp);
    }
    
    private static int f(int ind, int[] a, int n, int[] dp){
        if(ind==n-1) return 0;
        if(dp[ind]!=-1) return dp[ind];
        
        int mini=(int)1e9;
        for(int j=1;j<=a[ind];j++){
            if(ind+j<n)
                mini=Math.min(mini, 1+f(ind+j,a,n,dp));
        }
        return dp[ind]=mini;
    }
}