class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length; //rows
        int m=grid[0].length; //columns
        
        int[][] dp=new int[n][m];
        

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[0][0]=grid[0][0];
                else{
                    int up=(int)1e9; int left=(int)1e9;
                    if(i-1>=0) up=grid[i][j] + dp[i-1][j];
                    if(j-1>=0) left=grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
                
            }
        }
        
        return dp[n-1][m-1]; 
        
    }
    
}