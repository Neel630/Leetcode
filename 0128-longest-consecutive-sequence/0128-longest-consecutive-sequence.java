class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                int l = nums[i]-1, r = nums[i]+1;
                while(set.contains(l)){
                    set.remove(l);
                    l--;
                }
                while(set.contains(r)){
                    set.remove(r);
                    r++;
                }
                
                ans = Math.max(ans, r - l - 1);
            }
        }
        
        return ans;
    }
}