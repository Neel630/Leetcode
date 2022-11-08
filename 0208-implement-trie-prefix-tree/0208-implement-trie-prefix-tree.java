class Trie {
    public class Node{
        char val;
        Node[] childrens;
        boolean endsHere;

        Node(){
            childrens = new Node[26];
        }
        
        Node(char c){
            val = c;
            childrens = new Node[26];
        }
    }

    Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.childrens[c - 'a'];
            if(temp == null){
                temp = new Node();
                node.childrens[c - 'a'] = temp;
            }
            node = temp;
        }
        node.endsHere = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.childrens[c - 'a'];
            if(node == null){
                return false;
            }
        }
        return node.endsHere;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            node = node.childrens[c - 'a'];
            if(node == null){
                return false;
            }
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