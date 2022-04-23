# Memoization
​
```
class Solution {
public int coinChange(int[] coins, int amount) {
int n=coins.length;
int[][] dp=new int[n][amount+1];
for(int[] x:dp) Arrays.fill(x,-1);
int ans=f(n-1,coins,amount,dp);
if(ans>=(int)1e9) return -1;
return ans;
}
private static int f(int i, int[] coins, int target, int[][] dp){
if(target==0) return 0;
if(i==0){
if(target%coins[0]==0) return target/coins[0];
return (int)1e9;
}
if(dp[i][target]!=-1) return dp[i][target];
int p=(int)1e9;
if(coins[i]<=target) p=1 + f(i,coins,target-coins[i],dp);
int np=0+f(i-1,coins,target,dp);
return dp[i][target]=Math.min(p,np);
}
}
```