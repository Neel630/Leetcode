 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        
        for(int key : hm.keySet()){
            int freq = hm.get(key);
            if(bucket[freq]==null)
                bucket[freq] = new ArrayList<>();
            
            bucket[freq].add(key);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=bucket.length-1; i>0 && k>0; i--){
            if(bucket[i]!=null){
                res.addAll(bucket[i]);
                k-= bucket[i].size();
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}