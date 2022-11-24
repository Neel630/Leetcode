class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length; 
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(0, word, board, i, j, visited))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int w, String word, char[][] board, int i, int j, boolean[][] visited){
        if(w>=word.length()) return true;
        int n = board.length, m = board[0].length; 
        if(i<0 || i>=n || j<0 || j>=m) return false;
        
        char curr = word.charAt(w);
        
        boolean ans = false;
        if(board[i][j] == curr && !visited[i][j]){
            visited[i][j] = true;
            
            ans = ans || dfs(w+1, word, board, i-1, j, visited);
            ans = ans || dfs(w+1, word, board, i+1, j, visited);
            ans = ans || dfs(w+1, word, board, i, j-1, visited);
            ans = ans || dfs(w+1, word, board, i, j+1, visited);
            
            visited[i][j] = false;
            
        }
        return ans;
    }
}