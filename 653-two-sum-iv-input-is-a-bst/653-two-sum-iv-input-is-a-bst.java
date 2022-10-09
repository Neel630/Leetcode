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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    
    public boolean helper(TreeNode root, int t, HashSet set){
        if(root == null) return false;
        
        if(set.contains(t - root.val)) return true;
        set.add(root.val);
        return helper(root.left, t, set) || helper(root.right, t, set);
    }
}