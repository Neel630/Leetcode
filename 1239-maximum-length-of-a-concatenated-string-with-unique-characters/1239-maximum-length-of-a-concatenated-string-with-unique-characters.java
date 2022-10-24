class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, 0);
    }
    
    public int helper(List<String> arr, int i, int bit){
        if(i >= arr.size())
            return 0;
        
        int dupl = 0;
        for(char c : arr.get(i).toCharArray()){
            int j = c - 'a';
            if((dupl & (1<<j)) > 0) {
                return helper(arr, i+1, bit);
            }
            dupl = dupl | (1<<j);
        }
        
        if((bit & dupl) > 0) return helper(arr, i+1, bit);
                
        return Math.max(helper(arr, i+1, bit), arr.get(i).length() + helper(arr, i+1, bit | dupl));
    }
}