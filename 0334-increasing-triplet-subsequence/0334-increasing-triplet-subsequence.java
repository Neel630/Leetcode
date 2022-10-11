class Solution {
    public boolean increasingTriplet(int[] nums) {
        int lo = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        
        for(int i : nums){
            if(i <= lo){
                lo = i;
            }else if(i <= high){
                high = i;
            }else return true;
        }
        
        return false;
    }
}