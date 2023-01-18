class Solution {
    public int pivotIndex(int[] nums) {
        int ind = 0, total = 0;
        
        for(int i : nums) total+=i;
        
        int currentSum = 0;
        
        for(int i=0;i<nums.length;i++){
            
            if(currentSum == (total - currentSum - nums[i])) return i;
            
            currentSum +=nums[i];
            
        }
        
        return -1;
    }
}