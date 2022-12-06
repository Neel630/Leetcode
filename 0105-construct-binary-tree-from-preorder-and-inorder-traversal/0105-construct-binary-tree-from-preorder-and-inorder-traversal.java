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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        
        for(int i=inStart;i<=inEnd;i++){
            if(preorder[preStart] == inorder[i]){
                inIndex = i;
                break;
            }    
        }
        
        root.left = helper(preorder, inorder, preStart+1, inStart, inIndex -1);
        
        root.right = helper(preorder, inorder, preStart+inIndex - inStart +1, inIndex + 1, inEnd);
        
        return root;
    }
}