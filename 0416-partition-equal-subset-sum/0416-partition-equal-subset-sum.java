class Solution {
    // Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        
        if((sum&1)!=0) return false;
        
        // return helper(nums, 0, sum>>1);
        
        boolean[][] dp = new boolean[n+1][sum/2+1];
        
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        
        // for (int j = 1; j < sum+1; j++) {
        //     dp[0][j] = false;
        // }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum/2+1;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum>>1];
    }
    
//     public boolean helper(int[] nums, int i, int target){
//         if(target == 0) return true;
        
//         if(i>= nums.length || target < 0) return false;
        
//         if(dp[i][target] != null) return dp[i][target];
        
//         if(target >= nums[i]){
//             return dp[i][target] = helper(nums, i+1, target - nums[i]) || helper(nums, i+1, target);
//         }
        
//         return dp[i][target] = helper(nums, i+1, target);
//     }
}