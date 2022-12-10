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
    private long total = 0;
    private long maxProduct = 0;
    
    public int maxProduct(TreeNode root) {
        total = getSum(root);
        getProduct(root);
        
        return (int)(maxProduct % 1000000007);
    }
    
    public int getSum(TreeNode root){
        if(root == null) return 0;
        
        return getSum(root.left) + root.val + getSum(root.right);
    }
    
    public int getProduct(TreeNode root){
        if(root == null) return 0;
        
        int sub = getProduct(root.left) + root.val + getProduct(root.right);
        
        long currProduct = (long)(sub * (total - sub));
        maxProduct = Math.max(maxProduct, currProduct);
        
        return sub;
    }
}