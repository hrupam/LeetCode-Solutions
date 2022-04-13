class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words, (a,b)->a.length()-b.length());
        int[] dp=new int[n];
        int maxi=1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(isPossible(words[i],words[j])){
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    maxi=Math.max(dp[i], maxi);
                }
            }
        }
        return maxi;
    }
    
    private static boolean isPossible(String s1, String s2){
        if(s1.length()-s2.length()!=1) return false;
        int i=0; int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++; j++;
            }
            else i++;
        }
        if(i==s1.length() && j==s2.length()) return true;
        if(i==s1.length()-1 && j==s2.length()) return true;
        return false;
        
    }
}