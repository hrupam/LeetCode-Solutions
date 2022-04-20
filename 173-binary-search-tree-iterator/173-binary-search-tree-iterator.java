/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    private List<Integer> list=new ArrayList<>();
    private int i=-1;
    
    public BSTIterator(TreeNode root) {
        inOrder(root,list);
    }
    
    public int next() {
        return list.get(++i);
    }
    
    public boolean hasNext() {
        if(i+1<list.size()) return true;
        return false;
    }
    
    private static void inOrder(TreeNode root, List<Integer> list){
        if(root==null) return;
        
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */