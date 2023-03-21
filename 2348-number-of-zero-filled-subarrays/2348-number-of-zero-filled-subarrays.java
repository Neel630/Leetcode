class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long subarrays = 0;
        long continuousZero = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                subarrays += ++continuousZero;
            }else{
                continuousZero = 0;
            }
        }
        
        return subarrays;
    }
}