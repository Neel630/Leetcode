class Solution {
    public class Node{
        char val;
        Node[] childrens = new Node[26];
        String w;
        Node(){}
        Node(char c){
            val = c;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = build(words);
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, Node root, List<String> res){
        char c = board[i][j];
        
        if(c == '#' || root.childrens[c-'a']==null) return;
        
        if(root.childrens[c-'a'].w != null){
            res.add(root.childrens[c-'a'].w);
            root.childrens[c-'a'].w = null;
        }
        
        board[i][j] = '#';
        
        if(i>0) dfs(board, i-1, j, root.childrens[c-'a'], res);
        if(j>0) dfs(board, i, j-1, root.childrens[c-'a'], res);
        if(i<board.length-1) dfs(board, i+1, j, root.childrens[c-'a'], res);
        if(j<board[0].length-1) dfs(board, i, j+1, root.childrens[c-'a'], res);
        
        board[i][j] = c;
    }
    
    public Node build(String[] words){
        Node root = new Node('\0');
        
        for(String word : words){
            Node node = root;
            for(char c : word.toCharArray()){
                 if(node.childrens[c - 'a'] == null){
                    node.childrens[c-'a'] = new Node();
                }
                node = node.childrens[c-'a'];
            }
            node.w = word;
        }
        
        return root;
    }
}