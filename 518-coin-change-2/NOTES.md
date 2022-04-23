# Memoization
​
```
private static int f(int i, int[] coins, int amount, int[][] dp){
if(amount==0) return 1;
if(i==0){
if(amount%coins[0]==0) return 1;
return 0;
}
if(dp[i][amount]!=-1) return dp[i][amount];
int pick=0;
if(amount>=coins[i]) pick=f(i,coins,amount-coins[i],dp);
int notpick=f(i-1,coins,amount,dp);
return dp[i][amount]=pick+notpick;
}
```