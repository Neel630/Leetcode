class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        
        int product = 1;
        
        for(int i : nums){
            if(i == 0){
                zeros++;
            }else{
                product *= i; 
            }
        }
        
        int[] ans = new int[nums.length];
        
        if(zeros > 1)
            return ans;
        
        for(int i=0;i<nums.length;i++){
            if(zeros > 0 && nums[i] ==0 ){
                ans[i] = product;
            }else if(zeros > 0){
                ans[i] = 0;
            }else{
                ans[i] = product/nums[i];

            }
        }
        
        return ans;
    }
}