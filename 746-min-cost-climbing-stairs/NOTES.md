# Memoization
​
```
class Solution {
public int minCostClimbingStairs(int[] cost) {
int n=cost.length;
int[] dp=new int[n+1];
Arrays.fill(dp,-1);
return f(n,cost,dp);
}
private static int f(int i, int[] cost, int[] dp){
if(i<=1) return 0;
if(dp[i]!=-1) return dp[i];
int l=cost[i-1]+f(i-1,cost,dp);
int r=(int)1e9;
if(i-2>=0) r=cost[i-2]+f(i-2,cost,dp);
return dp[i]=Math.min(l,r);
}
}
```