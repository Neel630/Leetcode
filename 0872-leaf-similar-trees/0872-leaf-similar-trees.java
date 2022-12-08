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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");
        dfs(root1, s1);
        dfs(root2, s2);
        System.out.println("s1 "+s1);
        System.out.println("s2 "+s2);
        
        if(!s1.toString().equals(s2.toString())) return false;
        
        return true;
    }
    
    public void dfs(TreeNode root, StringBuilder stb){
        if(root == null) return;
        
        
        if(root.left == null && root.right == null){ 
            stb.append(Integer.toString(root.val) + "#");
            return;
        }
        
        dfs(root.left, stb);
        dfs(root.right, stb);
    }
}