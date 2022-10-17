class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        
        for(char c : sentence.toCharArray()){
            int ch = c - 'a';
            seen = seen | (1<<ch);
        }
        
        return seen == ((1<<26)-1);
    }
}