using BFS traversal
​
```
private static boolean f(int i, int[] color, int[][] adj){
Deque<Integer> queue=new ArrayDeque<>();
color[i]=0;
queue.offerLast(i);
while(!queue.isEmpty()){
int node=queue.pollFirst();
for(int j: adj[node]){
if(color[j]==-1){
color[j]=1-color[node];
queue.offerLast(j);
}
else if(color[node]==color[j]) return false;
}
}
return true;
}
```