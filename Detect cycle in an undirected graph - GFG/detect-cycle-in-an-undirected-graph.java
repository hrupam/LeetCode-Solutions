// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Solution {
    
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(hasCycle(i,vis,adj)) return true;
            }
        }
        return false;
    }
    
    private static boolean hasCycle(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Deque<Pair> queue=new ArrayDeque<>();
        vis[i]=true;
        queue.offerLast(new Pair(i,-1));
        while(!queue.isEmpty()){
            Pair pair=queue.pollFirst();
            int node=pair.first;
            int prev=pair.second;
            
            for(int j: adj.get(node)){
                if(!vis[j]){
                    queue.offerLast(new Pair(j,node));
                    vis[j]=true;
                }
                else if(j!=prev) return true;  
            }
        }
        return false;
    }
}