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
    long total = 0, res = 0; 
    public int maxProduct(TreeNode root) {
        total = sum(root); sum(root);
        return (int)(res % (int)(1e9 + 7));
    }
    
    public long sum(TreeNode root){
        if(root == null) return 0;
        long sub = root.val + sum(root.left) + sum(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }
}