class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        int p=s3.length();
        
        if(n+m!=p) return false;

        int[][][] dp=new int[n][m][p];
        for(int[][] x:dp) for(int[] y:x) Arrays.fill(y,-1);
        
        int res=f(n-1,m-1,p-1,s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),dp);
        
        return res==1;
    }
    
    private static int f(int i, int j, int k, char[] s1, char[] s2, char[] s3, int[][][] dp){
        if(i<0 && j<0){
            if(k<0) return 1;
            return 0;
        }
        
        if(i<0){
            while(j>=0 && k>=0){
                if(s2[j]!=s3[k]) return 0;
                j--; k--;
            }
            if(j<0 && k<0) return 1;
            return 0;
        }
        
        if(j<0){
            while(i>=0 && k>=0){
                if(s1[i]!=s3[k]) return 0;
                i--; k--;
            }
            if(i<0 && k<0) return 1;
            return 0;
        }
        
        if(k<0){
            if(i>=0) return 0;
            if(j>=0) return 0;
            return 1;
        }
        
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        
        if(s1[i]==s3[k] && s2[j]==s3[k])
            return dp[i][j][k]=f(i-1,j,k-1,s1,s2,s3,dp) | f(i,j-1,k-1,s1,s2,s3,dp);
        
        if(s1[i]==s3[k]) return dp[i][j][k]=f(i-1,j,k-1,s1,s2,s3,dp);
        
        if(s2[j]==s3[k]) return dp[i][j][k]=f(i,j-1,k-1,s1,s2,s3,dp);
        
        return dp[i][j][k]=0;
    }
}