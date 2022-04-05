class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxi=0;
        
        int l=0; int r=n-1;
        while(l<r){
            int d=r-l;
            maxi=Math.max(maxi, Math.min(height[l], height[r])*d);
            if(height[l]<height[r]) l++;
            else if(height[r]<height[l]) r--;
            else{
                l++; r--;
            }
        }
        return maxi;  
    }
}