class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final int N = jobDifficulty.length;
        if(N < d) return -1;

        int[][] memo = new int[N+1][d + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return dfs(d, 0, jobDifficulty, memo);
    }

    private int dfs(int d, int len, int[] jobDifficulty, int[][] dp){
        final int N = jobDifficulty.length;
        if(d==0 && len ==N) return 0;
        if(d==0 || len ==N) return Integer.MAX_VALUE;
                
        if(dp[len][d]!=-1)
            return dp[len][d];
        
        int currMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        
        for(int i=len;i<N;i++){
            currMax = Math.max(jobDifficulty[i], currMax);
            int temp = dfs(d-1, i+1, jobDifficulty, dp);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp+currMax);
        }
        
        return dp[len][d] = min;
    }
}