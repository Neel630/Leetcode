class Solution {
    public int[] findBall(int[][] grid) {
//         [[1,1,1,-1,-1],
//          [1,1,1,-1,-1],
//          [-1,-1,-1,1,1],
//          [1,1,1,1,-1],
//          [-1,-1,-1,-1,-1]]
        
//         [[1,1,1,1,1,1],
//          [-1,-1,-1,-1,-1,-1],
//          [1,1,1,1,1,1],
//          [-1,-1,-1,-1,-1,-1]]
        int m = grid[0].length;
        
        int[] ans = new int[m];
        
        for(int i=0;i<m;i++) ans[i] = helper(0,i,grid);
        
        return ans;
    }
    
    public int helper(int i, int j, int[][] mat){
        int n = mat.length, m = mat[0].length;
                
        if(i==n) return j;
        
        if(mat[i][j] == 1 && j+1<m && mat[i][j+1] == 1){
            return helper(i+1, j+1, mat);
        }else if(mat[i][j] == -1 && j-1>=0 && mat[i][j-1] == -1){
            return helper(i+1, j-1, mat);
        }
        
        return -1;
    }
}