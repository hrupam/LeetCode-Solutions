class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] dp=new int[n][m];
        for(int x[]: dp) Arrays.fill(x,-1);
        
        return f(grid, n-1, m-1, dp);
    }
    
    private static int f(int[][] grid, int i, int j, int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j]!=-1) return dp[i][j];
        
        int up=(int)1e9; int left=(int)1e9;
        
        
        //up
        if(i-1>=0) up=grid[i][j]+f(grid, i-1,j, dp);
        
        //left
        if(j-1>=0) left=grid[i][j]+f(grid, i, j-1, dp);
        
        return dp[i][j]=Math.min(up, left);
    }
}