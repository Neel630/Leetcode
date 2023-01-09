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
    public List<Integer> preorderTraversal(TreeNode root) {
        // Stack<TreeNode> stack = new Stack<>();
        
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
//         stack.push(root);
        
//         while(!stack.isEmpty()){
//             TreeNode temp = stack.pop();
//             if(temp != null){
//                 ans.add(temp.val);
//                 stack.push(temp.right);
//                 stack.push(temp.left);
//             }
//         }
        
        return ans;
    }
    
    public void helper(TreeNode root, List<Integer> ans){
        if(root == null) return;
        
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }
}