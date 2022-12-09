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
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, new ArrayList<Integer>());
        return max;
    }
    
    public void dfs(TreeNode root, List<Integer> arr){
        if(root == null) return;
        
        for(int a : arr){
            max = Math.max(max, Math.abs(a - root.val));
        }
        arr.add(root.val);
        dfs(root.left, new ArrayList<>(arr));
        dfs(root.right, new ArrayList<>(arr));
    }
}