class Solution {
    public int jump(int[] nums) {
        
        int n=nums.length;
        int[] dp=new int[n];
        
        for(int ind=n-2;ind>=0;ind--){
            int mini=(int)1e9;
            for(int j=1;j<=nums[ind];j++){
                if(ind+j<n) mini=Math.min(mini, 1+dp[ind+j]);
            }
            
            dp[ind]=mini;
        }
        
        return dp[0];
    }
}