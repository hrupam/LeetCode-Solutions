# -- Memoization --
​
```
private static int f(int i, int j, int[] cuts, int[][] dp){
if(i>j) return 0;
if(dp[i][j]!=-1) return dp[i][j];
int mini=(int)1e9;
for(int k=i;k<=j;k++){
int cost=(cuts[j+1]-cuts[i-1]) + f(i,k-1,cuts,dp)+f(k+1,j,cuts,dp);
mini=Math.min(mini, cost);
}
return dp[i][j]=mini;
}
```
​
**Call f(1,N-2,cuts,dp)**  where, *dp[][] is of size N, N=length of array after appending 0 and n (length of stick).*
​
​
​
​
​
​
​
​
​
​
​
​
​
​