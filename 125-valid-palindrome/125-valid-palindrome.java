class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        return f(0, s.length() - 1, s.toCharArray());
    }

    private static boolean f(int l, int r, char[] str) {
        if (l >= r) return true;
        if (!Character.isLetterOrDigit(str[l]) && !Character.isLetterOrDigit(str[r])) return f(l + 1, r - 1, str);
        if (!Character.isLetterOrDigit(str[l])) return f(l + 1, r, str);
        if (!Character.isLetterOrDigit(str[r])) return f(l, r - 1, str);
        if (Character.toLowerCase(str[l]) != Character.toLowerCase(str[r])) return false;

        return f(l + 1, r - 1, str);
    }
}
