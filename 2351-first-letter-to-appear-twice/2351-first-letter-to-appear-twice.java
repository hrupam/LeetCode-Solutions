class Solution {

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return c;
            set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
