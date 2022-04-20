class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int x:cuts) list.add(x);
        list.add(n);
        cuts=list.stream().mapToInt(i->i).toArray();
        
        int len=cuts.length;
        int[][] dp=new int[len][len];
        for(int[] x:dp) Arrays.fill(x,-1);
        
        return f(1,len-2,cuts,dp);   
    }
    
    private static int f(int i, int j, int[] cuts, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int mini=(int)1e9;
        for(int k=i;k<=j;k++){
            int cost=(cuts[j+1]-cuts[i-1]) + f(i,k-1,cuts,dp)+f(k+1,j,cuts,dp);
            mini=Math.min(mini, cost);
        }
        return dp[i][j]=mini;
    }
}