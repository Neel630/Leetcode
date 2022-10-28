class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);
            
            if(!hm.containsKey(sortedS)){
                hm.put(sortedS, new ArrayList<>());
            }
            
            hm.get(sortedS).add(s);
            
        }
        
        return new ArrayList<>(hm.values());
    }
}