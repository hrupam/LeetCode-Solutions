class Solution {
    //Tabulation
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][][] dp=new int[n][m][m];
        
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2]=grid[n-1][j1];
                else dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=(int)-1e9;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int value=0;
                            if(j1==j2) value=grid[i][j1];
                            else value=grid[i][j1]+grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m) value+=dp[i+1][j1+dj1][j2+dj2];
                            else value=(int)-1e9;
                            maxi=Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
        
    }
    
    //Memoization
    private static int f(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp){
        if(j1<0 || j1>=m || j2<0 || j2>=m) return (int)-1e9;
        if(i==n-1){
            if(j1==j2) return grid[n-1][j1];
            return grid[n-1][j1]+grid[n-1][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        
        int maxi=(int)-1e9;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value=f(i+1,j1+dj1,j2+dj2,n,m,grid,dp);
                if(j1==j2) value+=grid[i][j1];
                else value+=grid[i][j1]+grid[i][j2];
                maxi=Math.max(maxi, value);
            }
        }
        
        return dp[i][j1][j2]=maxi;
    }
}