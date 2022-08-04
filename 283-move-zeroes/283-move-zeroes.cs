public class Solution {
    public void MoveZeroes(int[] nums) {
        int n=nums.Length;
        int right=0; int left=0;
        while(right<n){
            if(nums[right]==0) right++;
            else{
                Swap(left,right,nums);
                left++;
                right++;
            }
        }
    }
    
    static void Swap(int i, int j, int[] arr){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}