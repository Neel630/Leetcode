class WordDictionary {
    class Node{
        char ch;
        String word = "";
        Node[] next;
        
        Node(char c){
            ch = c;
            next = new Node[26];
        }
    }
    
    Node arr;
    
    public WordDictionary() {
        arr = new Node('\0');
    }
    
    public void addWord(String word) {
        Node root = arr;
        for(char c : word.toCharArray()){
            
            if(root.next[c-'a'] == null){
                root.next[c-'a'] = new Node(c);
            }
            
            root = root.next[c-'a'];
        }
        root.word = word;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, arr);
    }
    
    public boolean match(char[] ch, int k, Node node){
        if(k>=ch.length) return !node.word.equals("");
        
        if(ch[k] != '.'){
            return node.next[ch[k]-'a'] != null && match(ch, k+1, node.next[ch[k] - 'a']);
        }else{
            for(int i=0;i<26;i++){
                if(node.next[i] != null){
                    if (match(ch, k + 1, node.next[i])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */