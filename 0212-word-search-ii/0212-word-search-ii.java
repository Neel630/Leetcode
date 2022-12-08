class Solution {
    
    class Node{
        char c;
        String word;
        Node[] next;
        
        Node(char ch){
            c = ch;
            next = new Node[26];
        }
    }
    
    Node trie;
    List<String> ans;
    
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Node('\0');
        ans = new ArrayList<>();
        
        for(String word : words){
            buildTrie(word);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];
                if(trie.next[c-'a']!=null){
                    dfs(i, j, board, trie);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j, char[][] board, Node curr){
        int n = board.length;
        int m = board[0].length;
        if(i<0 || j<0 || j>=m || i>=n) return;
        
        char c = board[i][j];
        if(c == '#') return;
        
        if(curr.next[c-'a'] == null) return;
        
        if(curr.next[c-'a'].word != null){
            ans.add(curr.next[c-'a'].word);
            curr.next[c-'a'].word = null;
        }
        
        curr = curr.next[c-'a'];
        
        board[i][j] = '#';
        
        dfs(i+1, j, board, curr);
        dfs(i-1, j, board, curr);
        dfs(i, j+1, board, curr);
        dfs(i, j-1, board, curr);
        
        board[i][j] = c;
        
    } 
    
    public void buildTrie(String word){
        Node curr = trie;
        
        for(char c : word.toCharArray()){
            if(curr.next[c-'a'] == null){
                curr.next[c-'a'] = new Node(c);
            }
            curr = curr.next[c-'a'];
        }
        
        curr.word = word;
        
    }
}