class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==2) return Math.max(nums[0],nums[1]);
        if(n==1) return nums[0];
        if(n==0) return 0;
        
        int[] dp=new int[n];
        
        Arrays.fill(dp,-1);
        int l=f(0,nums,n-1,dp);
        
        Arrays.fill(dp,-1);
        int r=f(1,nums,n,dp);
        
        return Math.max(l,r);  
    }
    
    private static int f(int i, int[] nums, int n, int[] dp){
        if(i==n-1) return nums[n-1];
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int l=nums[i]+f(i+2,nums,n,dp);
        int r=f(i+1,nums,n,dp);
        
        return dp[i]=Math.max(l,r);
    }
}