class Solution {
    int M = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> powers =  new ArrayList<>();
        
        int ithInd = 0;
        while(n!=0){
            if((n&1)==1)
                powers.add((int)Math.pow(2,ithInd));
            n = n >> 1;
            ithInd++;
        }
                
        System.out.println(powers);
        int[] ans = new int[queries.length];
        int ind = 0;
        for(int[] q : queries){
            int l = q[0], r = q[1];
            double temp = 1;
            for(int i=l;i<=r;i++){                
                temp = (temp * powers.get(i))%M;
            }
            
            ans[ind++] = (int)(temp)%M;
        }
        
        return ans;
    }

}