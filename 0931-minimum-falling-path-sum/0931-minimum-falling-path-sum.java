class Solution {
    Integer[][]  dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        dp = new Integer[n][n];
        
        for(int i = 0; i< n;i++) res = Math.min(res, helper(matrix, 0, i));
        
        return res;
    }
    
    public int helper(int[][] matrix, int i, int j){
        int n = matrix.length, m = matrix[0].length;
        
        if(i<0 || j<0 || i>n-1 || j >m-1) return Integer.MAX_VALUE;
        if(i==m-1) return matrix[i][j];
        
        if(dp[i][j] != null) return dp[i][j];
        
        return dp[i][j] = matrix[i][j] + Math.min(
            helper(matrix, i+1, j-1), 
            Math.min(
                helper(matrix, i+1, j), 
                helper(matrix, i+1, j+1)
            ));
        
    }
}