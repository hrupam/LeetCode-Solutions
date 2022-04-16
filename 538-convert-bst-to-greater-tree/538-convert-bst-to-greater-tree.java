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
class Solution {
    public TreeNode convertBST(TreeNode root) {
        TreeNode cur= root;
        int sum = 0;
        while (cur != null) {
            if (cur.right == null) {
                int tmp = cur.val;
                cur.val += sum;
                sum += tmp;
                cur = cur.left;
            } else {
                TreeNode prev = cur.right;
                while (prev.left != null && prev.left != cur)
                    prev = prev.left;
                if (prev.left == null) {
                    prev.left = cur;
                    cur = cur.right;
                } else {
                    prev.left = null;
                    int tmp = cur.val;
                    cur.val += sum;
                    sum += tmp;
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}