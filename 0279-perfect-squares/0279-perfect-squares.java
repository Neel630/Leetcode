class Solution {
    // Integer[] dp;
    public int numSquares(int n) {
        // dp = new Integer[n+1];
        
        // return helper(n);
        
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=n;i++){
            int sqrt = (int)Math.sqrt(i);
            
            if(sqrt*sqrt == i) {
                dp[i] = 1;
                continue;
            }
            
            for(int j=1;j<=sqrt;j++){
                dp[i] = Math.min(dp[i], dp[i-(j*j)] + 1);
            }
        }
        
        return dp[n];
    }
    
//     public int helper(int n){
//         if(n==0) return 0;
//         if(isPerfectSq(n)) return 1;
        
//         if(n<0) return Integer.MAX_VALUE;
        
//         if(dp[n] != null) return dp[n];
        
//         int ans = Integer.MAX_VALUE;
//         for(int i=1;i*i<=n;i++){
//             ans = Math.min(1 + helper(n - (i*i)), ans);
//         }
        
//         return dp[n] = ans;
//     }
    
//     public boolean isPerfectSq(int n){
//         if (Math.ceil((double)Math.sqrt(n)) ==
//         Math.floor((double)Math.sqrt(n)))
//         {
//             return true;
//         }
//         return false;
    
//     }
}