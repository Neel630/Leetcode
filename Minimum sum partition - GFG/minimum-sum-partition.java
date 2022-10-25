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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    
	    for(int i : arr) sum += i;
	    
	    boolean[][] dp = new boolean[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++) dp[i][0] = true;
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
	            if(j>=arr[i-1]){
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }   
	    }
	    
	    boolean[] rangeArr = dp[n];
	    
	    int min = Integer.MAX_VALUE;
 
	    for(int i=0;i<rangeArr.length/2+1;i++){
	       // System.out.println(rangeArr[i]);
	        if(rangeArr[i])
	            min = Math.min(min, Math.abs(sum - (2*i)));
	    }
	    
	    return min;
	} 
}
