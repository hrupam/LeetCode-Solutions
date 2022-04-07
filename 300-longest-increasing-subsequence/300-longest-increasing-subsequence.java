class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
        //for(int[] x:dp) Arrays.fill(x,-1);
        
        // return f(0,-1,nums,n,dp);
        
        for(int i=n-1;i>=0;i--){
            for(int lasti=i-1;lasti>=-1;lasti--){
                
                int p=0;
                if(lasti==-1 || nums[i]>nums[lasti]) p=1+dp[i+1][i+1];
                int np=dp[i+1][lasti+1];

                dp[i][lasti+1]=Math.max(p,np);
            }
        }
        
        return dp[0][0];
    }
    
    static int f(int i, int lasti, int[] a, int n, int[][] dp){ 
        if(i==n) return 0;
        
        if(dp[i][lasti+1]!=-1) return dp[i][lasti+1];
        
        int p=0;
        if(lasti==-1 || a[i]>a[lasti]) p=1+f(i+1,i, a,n,dp);
        int np=f(i+1,lasti, a,n,dp);
        
        return dp[i][lasti+1]=Math.max(p,np);
        
    }
}