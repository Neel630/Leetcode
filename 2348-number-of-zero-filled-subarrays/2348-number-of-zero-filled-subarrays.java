class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long subarrays = 0;
        long numZero = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                numZero++;
            }else{
                subarrays += (numZero*(numZero+1))/2;
                numZero = 0;
            }
        }
        
        subarrays += (numZero*(numZero+1))/2;
        return subarrays;
    }
}