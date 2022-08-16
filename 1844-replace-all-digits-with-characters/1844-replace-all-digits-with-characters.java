class Solution {

    public String replaceDigits(String s) {
        int n = s.length();
        char[] str = s.toCharArray();

        for (int i = 1; i < n; i += 2) {
            str[i] = shift(str[i - 1], Character.digit(str[i], 10));
        }

        return String.valueOf(str);
    }

    private char shift(char c, int n) {
        return (char) (c + n);
    }
}
