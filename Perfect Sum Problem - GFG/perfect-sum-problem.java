//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int[][] dp;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int M = 1000000007;
	    dp = new int[n+1][sum+1];
	    
	   // return helper(arr,0,sum);

	    for(int i=0;i<n+1;i++) dp[i][0] = 1;
	   
	    for(int i=1;i<n+1;i++){
    	    for(int j=0;j<sum+1;j++){
	            if(j >= arr[i-1]){
	                dp[i][j] =( dp[i-1][j-arr[i-1]] + dp[i-1][j])%M;
	            }else{
	                dp[i][j] = dp[i-1][j]%M;
	            }
            }
	    }
	    
	   // for(int i=0;i<n+1;i++){
    // 	    for(int j=0;j<sum+1;j++){
	   //         System.out.print(dp[i][j] +" ");
    //         }
    //         System.out.println();
	   // }
	    
	    return dp[n][sum];

	} 
	
// 	public int helper(int[] arr, int i, int sum){
	    
// 	    if(i >= arr.length) return 0;
	    
// 	    if(dp[i][sum] != null) return dp[i][sum];
	    
// 	    if(sum==arr[i]){
// 	        return dp[i][sum] = 1 + helper(arr, i+1, sum);
// 	    }else if(sum > arr[i]){
// 	        return dp[i][sum] = helper(arr, i+1, sum - arr[i]) + helper(arr, i+1, sum);
// 	    }
// 	    return dp[i][sum] = helper(arr, i+1, sum);
// 	}
}