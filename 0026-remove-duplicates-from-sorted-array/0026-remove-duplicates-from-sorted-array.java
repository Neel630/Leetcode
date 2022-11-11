class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if(n <=1) return n;
        
        int i = 0, j = 1;
        
        while(j<n){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];                
            }
            
            j++;
        }
        
        i++;
        return i;
    }
}