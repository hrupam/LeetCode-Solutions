class Solution {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new TreeSet<>();
        for (char c : sentence.toCharArray()) set.add(c);
        return set.size() == 26;
    }
}
