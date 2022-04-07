class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int[][] dp=new int[n+1][n+1];
        
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
}