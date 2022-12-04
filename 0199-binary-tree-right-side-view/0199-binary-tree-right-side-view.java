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
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }
    
    public void dfs(TreeNode root, int height){
        if(root == null) return;
        
        if(height == ans.size()) ans.add(root.val);
        else ans.set(height, root.val);
        
        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
}