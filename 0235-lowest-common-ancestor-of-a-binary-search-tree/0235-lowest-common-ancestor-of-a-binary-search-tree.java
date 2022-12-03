/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val) return p;
        if(root.val == q.val) return q;
        if(root.val < p.val && root.val < q.val){
            TreeNode left = lowestCommonAncestor(root.right, p, q);
            return left == null ? root : left;
        }else if(root.val > p.val && root.val > q.val){
            TreeNode right = lowestCommonAncestor(root.left, p, q);
            return right == null ? root : right;
        }
        
        return root;
        
    }
    
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root.val == p.val) return p;
        if(root.val == q.val) return q;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;
        
        return null;
    }
}