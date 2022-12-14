class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return helper(nums, 0);
    }
    
    public int helper(int[] nums, int prev){
        if(prev >= nums.length) return 0;
        
        if(dp[prev] != null) return dp[prev];
        
        return dp[prev] = Math.max(
            helper(nums, prev+1),
            nums[prev] + helper(nums, prev+2)
                       );
    }
}