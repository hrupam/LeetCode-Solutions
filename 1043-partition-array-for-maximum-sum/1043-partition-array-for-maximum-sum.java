class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,arr,n,k,dp);
    }
    
    private static int f(int i, int[] arr, int n, int k, int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int maxNo=arr[i]; int maxi=(int)-1e9;
        for(int j=i;j<i+k && j<n;j++){
            maxNo=Math.max(maxNo,arr[j]);
            int cost=(j-i+1)*maxNo + f(j+1,arr,n,k,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i]=maxi;    
    }
}