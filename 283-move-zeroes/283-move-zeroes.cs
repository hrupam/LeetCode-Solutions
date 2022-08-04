public class Solution {
    public void MoveZeroes(int[] nums) {
        int n=nums.Length;
        int left=0; int right=0;
        
        while(right<n){
            if(nums[right]!=0) Swap(left++,right,nums);
            right++;
        }
    }
    
    static void Swap(int i, int j, int[] arr){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}