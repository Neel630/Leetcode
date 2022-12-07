/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp == null) {
                    sb = sb.append("null ");
                }
                else {
                    
                    sb = sb.append(Integer.toString(temp.val)+ " ");
                    
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }
        System.out.println("string "+sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("string des "+data);
         if (data == "") return null;
        String[] sb = data.split(" ");
//          for(String s : sb){
//             System.out.println("data "+s);
            
//         }
        
//         return insert(sb,0);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(sb[0]));
        q.offer(root);
        
        for(int i=1;i<sb.length;i++){
            TreeNode par = q.poll();
            
            if(!sb[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(sb[i]));
                par.left = left;
                q.offer(left);
            }
            
            if(!sb[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(sb[i]));
                par.right = right;
                q.offer(right);
            }
        }
        
        return root;
        
    }
    
    public TreeNode insert(String[] arr, int i){
        TreeNode root = null;
        
        if(i< arr.length){
            if(arr[i].equals("null")) return null;
            System.out.println("ith "+arr[i]);
            
            root = new TreeNode(Integer.parseInt(arr[i]));
            root.left = insert(arr,(2*i)+1);
            root.right = insert(arr,(2*i)+2);
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));