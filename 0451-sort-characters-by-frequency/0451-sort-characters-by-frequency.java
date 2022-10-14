
class Solution {
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder("");
        
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> pair = pq.poll();
            for (int i = 0; i < pair.getValue(); i++) 
                sb.append(pair.getKey());
        }
        
        
        return sb.toString();
    }
}