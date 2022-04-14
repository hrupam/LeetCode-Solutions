class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        
        int maxLIS=1;
        for(int i=0;i<n;i++){
            dp[i]=1; count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        maxLIS=Math.max(maxLIS,dp[i]);
                        count[i]=count[j];
                    }
                    else if(dp[j]+1==dp[i]) count[i]+=count[j];
                }
            }
        }
        
        int ctr=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLIS) ctr+=count[i];
        }
        
        return ctr;
    }
}