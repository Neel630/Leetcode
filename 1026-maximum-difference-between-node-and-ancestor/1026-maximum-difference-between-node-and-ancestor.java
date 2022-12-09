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

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    public int dfs(TreeNode root, int currMax, int currMin){
        if(root == null) return currMax - currMin;
        
        currMax = Math.max(currMax, root.val);
        currMin = Math.min(currMin , root.val);

        return Math.max(
        dfs(root.left, currMax, currMin),
        dfs(root.right, currMax, currMin)
        );
    }
}