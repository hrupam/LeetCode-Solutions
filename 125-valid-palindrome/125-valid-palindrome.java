class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) l++; else if (!Character.isLetterOrDigit(s.charAt(r))) r--; else if (
                Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))
            ) return false; else {
                l++;
                r--;
            }
        }
        return true;
    }
}
