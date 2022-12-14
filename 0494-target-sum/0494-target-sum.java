class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for(int i: nums) sum+= i;
        
        if((sum-target)%2!=0 || target>sum) return 0;
        sum = (sum-target)/2;
        
        int[][] dp = new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }   
        }
        
        return  dp[n][sum];
    }
}