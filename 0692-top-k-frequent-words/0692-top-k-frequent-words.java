class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String s : words){
            hm.put(s, hm.getOrDefault(s, 0)+1);
        }
        
        List<String>[] bucket = new ArrayList[words.length];
        
        for(String key : hm.keySet()){
            int freq = hm.get(key);
            
            if(bucket[freq]== null)
                bucket[freq] = new ArrayList<>();
            
            bucket[freq].add(key);
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=words.length-1;i>=0 && k>0 ;i--){
            if(bucket[i]!=null){                
                List<String> temp = bucket[i];
                Collections.sort(temp);                
                ans.addAll(temp);
                k -= temp.size();
                
                if(k < 0){
                    while(k!=0){
                        ans.remove(ans.size()-1);
                        k++;
                    }
                }
            }
        }
        
        return ans;
    }
}