class Solution {
    public int maxCoins(int[] nums) {
        int N=nums.length;
        List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0,1);
        list.add(1);
        nums=list.stream().mapToInt(i->i).toArray();
        
        int[][] dp=new int[N+1][N+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        
        return f(1,N,nums,dp);
    }
    
    private static int f(int i, int j, int[] nums, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int maxi=(int)-1e9;
        for(int k=i;k<=j;k++){
            int coins=(nums[i-1]*nums[k]*nums[j+1]) + f(i,k-1,nums,dp) + f(k+1,j,nums,dp);
            maxi=Math.max(coins,maxi);
        }
        return dp[i][j]=maxi;
    }
}