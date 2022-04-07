class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        
        for(int[] x:dp) Arrays.fill(x,-1);
        
        return f(0,-1,nums,n,dp);
    }
    
    static int f(int i, int lasti, int[] a, int n, int[][] dp){ 
        if(i==n-1){
            if(lasti==-1 || a[n-1]>a[lasti]) return 1;
            return 0;
        }
        
        if(dp[i][lasti+1]!=-1) return dp[i][lasti+1];
        
        int p=0;
        if(lasti==-1 || a[i]>a[lasti]) p=1+f(i+1,i, a,n,dp);
        int np=f(i+1,lasti, a,n,dp);
        
        return dp[i][lasti+1]=Math.max(p,np);
        
    }
}