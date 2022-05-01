class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack=new ArrayDeque<>();
        Deque<Character> tStack=new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='#') sStack.offerLast(c);
            else sStack.pollLast();
        }
        
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(c!='#') tStack.offerLast(c);
            else tStack.pollLast();
        }
        
        if(sStack.size()!=tStack.size()) return false;
        
        while(sStack.size()!=0) if(sStack.pollLast()!=tStack.pollLast()) return false;
        
        return true;
    }
}