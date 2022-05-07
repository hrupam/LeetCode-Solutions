class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int maxNo=arr[i]; int maxi=(int)-1e9;
            for(int j=i;j<i+k && j<n;j++){
                maxNo=Math.max(maxNo,arr[j]);
                int cost=(j-i+1)*maxNo + dp[j+1];
                maxi=Math.max(maxi,cost);
            }
            dp[i]=maxi;  
        }
        return dp[0];
    }
}