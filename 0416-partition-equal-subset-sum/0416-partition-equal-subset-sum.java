class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        
        if((sum&1)!=0) return false;
        
        dp = new Boolean[n+1][(sum>>1 )+ 1];
        
        return helper(nums, 0, sum>>1);
        
//         boolean[][] dp = new boolean[n+1][sum/2+1];
        
//         for(int i=0;i<n+1;i++){
//             for(int j=0;j<sum/2+1;j++){
                                
//             }
//         }
        
    }
    
    public boolean helper(int[] nums, int i, int target){
        if(target == 0) return true;
        
        if(i>= nums.length || target < 0) return false;
        
        if(dp[i][target] != null) return dp[i][target];
        
        return dp[i][target] = helper(nums, i+1, target - nums[i]) || helper(nums, i+1, target);
    }
}