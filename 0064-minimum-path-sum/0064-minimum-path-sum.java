class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        dp = new Integer[m][n];
        return findOptimizePathFromPosition(0,0,grid);
    }
    
    public int findOptimizePathFromPosition(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i <0 || i>=m || j<0 || j>=n) return Integer.MAX_VALUE - 1;
        if(i == m-1 && j == n-1) return grid[i][j];
        
        if(dp[i][j] != null) return dp[i][j];
        
        int down = findOptimizePathFromPosition(i+1, j, grid);
        int right =  findOptimizePathFromPosition(i, j+1, grid);
        
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}