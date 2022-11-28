class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> hm = new TreeMap<>();
        
        for(int[] match : matches){
            hm.put(match[0], hm.getOrDefault(match[0], 0));
            hm.put(match[1], hm.getOrDefault(match[1], 0)+1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        
        for (Integer i : hm.keySet()) {
            if(hm.get(i) <=1){
                ans.get(hm.get(i)).add(i);
            }
        }
        
        return ans;
    }
}