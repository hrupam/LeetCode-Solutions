class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int x:cuts) list.add(x);
        list.add(n);
        cuts=list.stream().mapToInt(i->i).toArray();
        
        int N=cuts.length;
        
        int[][] dp=new int[N][N];
            
        for(int i=N-2;i>=1;i--){
            for(int j=i;j<=N-2;j++){
                
                int mini=(int)1e9;
                
                for(int k=i;k<=j;k++){
                    int cost=(cuts[j+1]-cuts[i-1]) + dp[i][k-1]+dp[k+1][j];
                    mini=Math.min(mini, cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][N-2];
    }
}