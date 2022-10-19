class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String s : words){
            hm.put(s, hm.getOrDefault(s, 0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(
        (a,b) -> hm.get(a)==hm.get(b) ? a.compareTo(b) : hm.get(b) - hm.get(a)
        );
        
        pq.addAll(hm.keySet());
        
        List<String> ans = new ArrayList<>();
        while(k!=0){
            ans.add(pq.poll());
            k--;
        }
        
        return ans;
    }
}