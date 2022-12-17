class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int currMax = helper(grid, i, j);
                    max = Math.max(max, currMax);
                }
                
            }
        }
        
        return max;
    }
    
    public int helper(int[][] grid, int i, int j){
        int n = grid.length, m = grid[0].length;        
        
        if(i<0 || j<0 || i>=n || j>=m) return 0;
        
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + helper(grid, i-1,j) + helper(grid, i+1,j) + helper(grid, i,j+1) + helper(grid, i,j-1);
        }
        return 0;
    }
}