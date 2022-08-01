public class Solution {
    public int UniquePaths(int m, int n) {
        int[ , ] dp = new int [m, n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) dp[i,j]=-1;
        
        return f(0,0,m,n,dp);
    }
    
    private int f(int i, int j, int m, int n, int[,] dp){
        if(i==m-1 && j==n-1) return 1;
        if(dp[i,j]!=-1) return dp[i,j];
        
        int right=0; int down=0;
        if(j+1<n) right=f(i,j+1,m,n,dp);
        if(i+1<m) down=f(i+1,j,m,n,dp);
        
        return dp[i,j]=right+down;
    }
}