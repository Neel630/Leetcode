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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        
        boolean isSame = false;
        if(root.val == subRoot.val) isSame = isSameTree(root,subRoot);
        isSame = isSame || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        return isSame;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q ==null) return true;
        else if(p==null || q == null) return false;
        
        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        return false;
    }
}