class Solution {
    public int maxProduct(int[] nums) {
        int l = 0, r = 0, ans = nums[0];
        
        for(int i=0;i<nums.length;i++){
            l = (l ==0 ? 1 : l) * nums[i];
            r = (r ==0 ? 1 : r) * nums[nums.length-i-1];
            ans = Math.max(ans,Math.max(l,r));
        }
        
        return ans;
    }
}