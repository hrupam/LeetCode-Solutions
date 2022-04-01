class Solution {
    public void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        while(l<r){
            swap(s,l++,r--);
        }
    }
    
    private static void swap(char[] s, int l, int r){
        char t=s[l];
        s[l]=s[r];
        s[r]=t;
    }
}