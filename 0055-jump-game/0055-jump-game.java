class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0], maxReachFromHere = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(i>maxReach) return false;
            maxReach = Math.max(i+nums[i], maxReach);
        }
        
        return true;
    }
    
//     public boolean helper(int[] nums, int i){
//         int n = nums.length;
//         if(i>=n-1) return true;
        
//         if(dp[i]!=null) return dp[i];
        
         
//         for(int ind = 1;ind<=nums[i];ind++){
//             if(i>=n) return true;
//             boolean canReach = helper(nums, i+ind);
  
//             if(canReach){
//                 dp[i+ind] = true; 
//                 return true;
//             }else{
//                 dp[i+ind] = false; 
                
//             }
            
//         }
        
//         return dp[i] = false;
//     }
}