class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, min = 0;
        
        for(int i: weights){
            max += i;
            min = Math.max(i, min);
        }
        
        
        while(min < max){
            int mid = min + (max-min)/2;
            
            if(feasible(weights,days, mid))
                max = mid;
            else
                min = mid+1;
        }
        
        return min;
    }
    
    public boolean feasible(int[] weights, int days, int maxweight){
        int d = 1, curr = 0;
        for(int w : weights){
            curr += w;
            if(curr > maxweight){
                curr = w;
                d++;
                if(d>days) return false;
            }
        }
        
        return true;
    }
}