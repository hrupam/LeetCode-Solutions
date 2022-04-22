class Solution {
    public int maxCoins(int[] nums) {
        int N=nums.length;
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int x:nums) list.add(x);
        list.add(1);
        
        nums=list.stream().mapToInt(i->i).toArray();
        
        int[][] dp=new int[N+2][N+2];
        
        for(int i=N;i>=1;i--){
            for(int j=i;j<=N;j++){
                
                int maxi=(int)-1e9;
                for(int k=i;k<=j;k++){
                    int coins=(nums[i-1]*nums[k]*nums[j+1]) + dp[i][k-1] + dp[k+1][j];
                    maxi=Math.max(coins,maxi);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][N];
    }
}