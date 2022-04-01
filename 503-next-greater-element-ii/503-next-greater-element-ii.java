class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];
        Deque<Integer> st=new ArrayDeque<>();
        
        for(int i=2*n-1; i>=0; i--){
            
            while(!st.isEmpty() && st.peekFirst() <= nums[i%n]) st.pollFirst();
            
            if(!st.isEmpty()) nge[i%n]=st.peekFirst();
            else nge[i%n]=-1;
            
            st.offerFirst(nums[i%n]);
            
        }
        
        return nge;
    }
}