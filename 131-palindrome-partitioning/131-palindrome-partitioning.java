class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        List<List<String>> wrappedList = new LinkedList<>();
        f(s, 0, new ArrayList<>(), wrappedList, n);
        return wrappedList;
    }
    
    private void f(String s, int index, List<String> subList, List<List<String>> wrappedList, int n) {
        if (index == n) {
            wrappedList.add(new ArrayList<>(subList));
            return;
        }
        
        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                subList.add(s.substring(index, i + 1));
                f(s, i + 1, subList, wrappedList, n);
                subList.remove(subList.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (s.isEmpty() || s.isBlank() || s == null) return false;
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }
}