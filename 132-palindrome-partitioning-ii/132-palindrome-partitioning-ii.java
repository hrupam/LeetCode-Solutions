class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int mini=(int)1e9;
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    int cut=1+dp[j+1];
                    mini=Math.min(mini,cut);
                }
            }
            dp[i]=mini;
        }
        
        return dp[0]-1;
    }
    
    static boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}