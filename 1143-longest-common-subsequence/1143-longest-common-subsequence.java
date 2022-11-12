class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()+1][text2.length()+1];

        return helper(text1, text2, text1.length()-1, text2.length()-1);
    }
    
    public int helper(String s1, String s2, int i, int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + helper(s1,s2,i-1,j-1);
        
        return dp[i][j] = Math.max(helper(s1,s2,i-1,j), helper(s1,s2,i,j-1));
    }
}