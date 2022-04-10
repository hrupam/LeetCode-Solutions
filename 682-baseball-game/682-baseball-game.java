class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list=new ArrayList<>();
        
        for(String op: ops){
            
            if(op.equals("+")){
                int i=list.size()-1;
                list.add(list.get(i)+list.get(i-1));
            }
            
            else if(op.equals("D")) list.add(2*list.get(list.size()-1));
            
            else if(op.equals("C")) list.remove(list.size()-1);
            
            else list.add(Integer.parseInt(op));
            
        }
        
        int sum=0;
        for(int x: list) sum+=x;
        return sum;
    }
}