class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,s,n,dp);
    }
    
    static int f(int i, String s, int n, int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int mini=(int)1e9;
        for(int j=i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cut=0;
                if(j==n-1) cut=f(j+1,s,n,dp);
                else cut=1+f(j+1,s,n,dp);
                mini=Math.min(mini,cut);
            }
        }
        return dp[i]=mini;
    }
    
    static boolean isPalindrome(String s, int l, int r){
        if(l>=r) return true;
        if(s.charAt(l)!=s.charAt(r)) return false;
        return isPalindrome(s,l+1,r-1);
    }
}