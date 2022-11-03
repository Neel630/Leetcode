class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        int[][] counter = new int[26][26];
        
        for(String word : words){
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            
            if(counter[b][a] > 0){
               ans += 4;
                counter[b][a]--;
            }else{
                counter[a][b]++;
            }
        }
        
        for(int i=0;i<26;i++)
            if(counter[i][i] > 0) {
                ans += 2;
                break;
            }
        
        return ans;
    }
    
}