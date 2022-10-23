class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            ans[1] ^= val^(i+1);
            
            if(nums[val-1] < 0) ans[0] = val;
            else nums[val-1] = - nums[val-1];
        }
        ans[1] ^= ans[0];
        return ans;
    }
}
