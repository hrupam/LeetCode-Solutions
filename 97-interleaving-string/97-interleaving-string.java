class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        int p=s3.length();
        
        if(n+m!=p) return false;
        
        char[] s11=s1.toCharArray();
        char[] s22=s2.toCharArray();
        char[] s33=s3.toCharArray();

        int[][][] dp=new int[n][m][p];
        for(int[][] x:dp) for(int[] y:x) Arrays.fill(y,-1);
        
        int res=f(n-1,m-1,p-1,s11,s22,s33,dp);
        if(res==1) return true;
        return false;
    }
    
    private static int f(int i, int j, int k, char[] s1, char[] s2, char[] s3, int[][][] dp){
        if(i<0 && j<0){
            if(k<0) return 1;
            return 0;
        }
        if(i<0){
            if(k<0) return 0;
            if(String.valueOf(s2).substring(0,j+1).equals(String.valueOf(s3).substring(0,k+1))) return 1;
            return 0;
        }
        if(j<0){
            if(k<0) return 0;
            if(String.valueOf(s1).substring(0,i+1).equals(String.valueOf(s3).substring(0,k+1))) return 1;
            return 0;
        }
        if(k<0){
            if(i>=0) return 0;
            if(j>=0) return 1;
            return 1;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        
        if(s1[i]==s3[k] && s2[j]==s3[k]) return dp[i][j][k]=f(i-1,j,k-1,s1,s2,s3,dp) | f(i,j-1,k-1,s1,s2,s3,dp);
        if(s1[i]==s3[k]) return dp[i][j][k]=f(i-1,j,k-1,s1,s2,s3,dp);
        else if(s2[j]==s3[k]) return dp[i][j][k]=f(i,j-1,k-1,s1,s2,s3,dp);
        return dp[i][j][k]=0;
    }
}