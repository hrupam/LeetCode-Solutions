class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        char[] str=s.toCharArray();
        boolean[][] dp=new boolean[n][n];
        
        int count=n;
        for(int i=0;i<n;i++) dp[i][i]=true;
        
        for(int i=0;i+1<n;i++){
            int j=i+1;
            if(str[i]==str[j]){
                dp[i][j]=true;
                count++;
            }
        }
        
        for(int k=3;k<=n;k++){
            for(int i=0;i+k-1<n;i++){
                int j=i+k-1;
                if(str[i]==str[j] && dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        
        return count;
    }
}