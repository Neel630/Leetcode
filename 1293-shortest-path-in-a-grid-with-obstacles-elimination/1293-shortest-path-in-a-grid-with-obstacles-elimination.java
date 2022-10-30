class Solution {
    Integer[][][] dp;
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        dp = new Integer[n][m][k+1];
        int ans = helper(n-1, m-1, grid, k, visited);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int helper(int i, int j, int[][] mat, int k, boolean[][] visited){
        int n = mat.length, m = mat[0].length;
        
        if(i == 0 && j == 0) return 0;  
        
        if(i<0 || i >= n || j<0 || j>=m || visited[i][j]) return Integer.MAX_VALUE ;
        
        if(dp[i][j][k] != null) return dp[i][j][k];
        
        if(mat[i][j] == 1) k--;
        if(k<0) return Integer.MAX_VALUE;

        visited[i][j] = true;
        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, helper(i-1, j, mat, k, visited));
        ans = Math.min(ans, helper(i, j-1, mat, k, visited));
        ans = Math.min(ans, helper(i+1, j, mat, k, visited));
        ans = Math.min(ans, helper(i, j+1, mat, k, visited));
        visited[i][j] = false;

        dp[i][j][k] = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans + 1;
        return dp[i][j][k];
 
    }
}