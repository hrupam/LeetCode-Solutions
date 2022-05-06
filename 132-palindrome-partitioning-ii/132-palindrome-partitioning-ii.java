class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,s,n,dp)-1;
    }
    
    static int f(int i, String s, int n, int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int mini=(int)1e9;
        for(int j=i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cut=1+f(j+1,s,n,dp);
                mini=Math.min(mini,cut);
            }
        }
        return dp[i]=mini;
    }
    
    static boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}