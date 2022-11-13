class Solution {
    Set<String> set = new HashSet<>();
    Integer[] dp = new Integer[100001];
    int M = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;

        for(int i=low;i<=high;i++){
            ans = (ans%M + helper(i, zero, one))%M;
        }
        
        // help(low, high, 0, zero, one);
        // int[][] np = new int[low+1][high+1];
        
        
        // return set.size();
        return ans;
    }
    
    public int helper(int target, int z, int o){
        if(target == 0) return 1;
        if(target <0) return 0;
        if(dp[target] != null) return dp[target];
        
        int sum = helper(target-z,z,o) + helper(target-o,z,o);
        
        return dp[target] = sum%M;
    }
    
//     public void help(int lo, int hi, int len, int z, int o){
        
//         if(len > hi){
//             // System.out.println("high  "+s);
            
//             return;
//         }
        
//         if(len>= lo){
//             // System.out.println(s);
//             // set.add(s);
//             ans++;
//             // dp[len] = ans;
//         }
        
//         // if(dp[len]!=null) return;
        
//         // if(z+len<= hi){
//             // StringBuilder sb = new StringBuilder(s);
//             // for(int i=0;i<z;i++) sb.append("0");
//             help(lo, hi, len + z, z, o);
//         // }
        
//         // if(o+len <= hi){
//             // StringBuilder sb2 = new StringBuilder(s);
//             // for(int i=0;i<o;i++) sb2.append("1");
//             help(lo, hi, len + o, z, o);
//         // }
//     }
    
//     public void helper(int len, int z, int o, String s){
//         if(0==len){
//             // set.add(s);
//             ans++;
//             return;
//         }
        
//         if(z <= len){
//             StringBuilder sb = new StringBuilder(s);
//             // for(int i=0;i<z;i++) sb.append("0");
//             helper(len - z, z, o, sb.toString());
//         }
        
//         if(o <= len){
//             StringBuilder sb = new StringBuilder(s);
//             // for(int i=0;i<o;i++) sb.append("1");
//             helper(len - o, z, o, sb.toString());
//         }
//     }
}