class Solution {
    public int fib(int n) {
        return f(n);
    }
    
    private static int f(int n){
        if(n<=1) return n;
        
        return f(n-1)+f(n-2);
    }
}