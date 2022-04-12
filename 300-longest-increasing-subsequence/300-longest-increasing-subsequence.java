class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> temp=new ArrayList<>();
        temp.add(nums[0]);
        int len=1;
        for(int i=1;i<n;i++){
            if(temp.get(temp.size()-1)<nums[i]){
                temp.add(nums[i]); len++;
            }
            else{
                int ind=lowerBound(temp, nums[i]);
                temp.set(ind, nums[i]);
            }
        }
        return len;
    }
    
    private static int lowerBound(List<Integer> list, int x){
        int l=0;
        int r=list.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(list.get(mid)==x) return mid;
            else if(x<list.get(mid)) r=mid-1;
            else l=mid+1;
        }
        return l;
    }
}