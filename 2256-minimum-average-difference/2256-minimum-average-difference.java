class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length, minInd = 0;
        int[] prefix = new int[n];
        
        long sum = 0, min = Integer.MAX_VALUE;
        for(int i : nums) sum += i;
        
        long currSum = 0;
        
        for(int i = 0;i<n;i++){
            currSum += nums[i];
            
            if(i==n-1){
                if(min > (sum/n)){
                    minInd = i;
                    min = (sum/n);
                }
            }else{
                long leftSum = (currSum/(i+1));
                long rightSum = ((sum-currSum)/(n-i-1));

                if(min > Math.abs(leftSum -rightSum )){
                    minInd = i;
                    min = Math.abs(leftSum -rightSum);
                }
            }
        }
        
        return minInd;
    }
}