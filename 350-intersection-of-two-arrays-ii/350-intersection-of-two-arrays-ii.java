class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums1) map.put(x,map.getOrDefault(x,0)+1);
        
        List<Integer> list=new ArrayList<>();
        for(int x:nums2){
            if(map.containsKey(x)){
                list.add(x);
                map.put(x,map.get(x)-1);
                if(map.get(x)==0) map.remove(x);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}