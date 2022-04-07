class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list=Arrays.stream(stones).boxed().collect(Collectors.toList());
        
        while(list.size()>1){
            Collections.sort(list, Comparator.reverseOrder());
            int i=0; int j=1;
            int x=list.get(j);
            int y=list.get(i);
            
            if(x==y){
                list.remove(j); list.remove(i);
            }
            else{
                list.remove(j);
                list.set(i, y-x);
            }
        }
        if(list.size()==1) return list.get(0);
        return 0;
    }
}