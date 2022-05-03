# Memoization
​
```
class Solution {
public int rob(int[] nums) {
int n=nums.length;
int[] dp=new int[n];
Arrays.fill(dp,-1);
return f(0,nums,n,dp);
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
```