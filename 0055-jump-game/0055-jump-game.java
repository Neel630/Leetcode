class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length+1];
        return helper(nums, 0);
    }
    
    public boolean helper(int[] nums, int i){
        int n = nums.length;
        if(i>=n-1) return true;
        
        if(dp[i]!=null) return dp[i];
        
         
        for(int ind = 1;ind<=nums[i];ind++){
            if(i>=n) return true;
            boolean canReach = helper(nums, i+ind);
  
            if(canReach){
                dp[i+ind] = true; 
                return true;
            }else{
                dp[i+ind] = false; 
                
            }
            
        }
        
        return dp[i] = false;
    }
}