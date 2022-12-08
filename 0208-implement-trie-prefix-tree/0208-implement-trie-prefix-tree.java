class Trie {

    class Node{
        char ch;
        boolean endsHere;
        Node[] next = new Node[26];
        
        Node(char c){
            ch = c;
        }
    }
    
    Node arr;
    public Trie() {
         arr = new Node('\0');
    }
    
    public void insert(String word) {
        Node root = arr;
        for(char c : word.toCharArray()){
            
            if(root.next[c-'a'] == null){
                root.next[c-'a'] = new Node(c);
            }
            
            root = root.next[c-'a'];
        }
        root.endsHere = true;
    }
    
    public boolean search(String word) {
        Node root = arr;
        for(char c : word.toCharArray()){
            
            if(root.next[c-'a'] == null){
                return false;
            }
            
            root = root.next[c-'a'];
        }
        return root.endsHere == true;
    }
    
    public boolean startsWith(String prefix) {
        Node root = arr;
        for(char c : prefix.toCharArray()){
            
            if(root.next[c-'a'] == null){
                return false;
            }
            
            root = root.next[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */