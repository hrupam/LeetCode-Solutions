class Solution {

    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        int x = (int) (Math.log10(n) / Math.log10(4));
        return (int) Math.pow(4, x) == n;
    }
}
