class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int si=0,sj=0,zero = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    si = i;
                    sj = j;
                }else if(grid[i][j] == 0){
                    zero+=1;
                }
            }
        }
        
        return dfs(si,sj,grid,zero);
    }
    
    public int dfs(int i, int j, int[][] grid, int zero){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==-1){
            return 0;
        }
        
        if(grid[i][j] == 2){
            return zero == -1 ? 1 : 0;
        }
        
        grid[i][j] = -1;
        zero--;
        
        int temp = dfs(i-1,j,grid,zero) +  dfs(i+1,j,grid,zero) + 
            dfs(i,j-1,grid,zero) + dfs(i,j+1,grid,zero);
        
        grid[i][j] = 0;
        zero++;
        return temp;
    }
}