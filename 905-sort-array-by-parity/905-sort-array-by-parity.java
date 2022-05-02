class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)==0) deque.offerFirst(nums[i]);
            else deque.offerLast(nums[i]);
        }
        
        int[] arr=new int[deque.size()];
        
        for(int i=0;i<arr.length;i++)
            arr[i]=deque.pollFirst();
        
        return arr;
    }
}