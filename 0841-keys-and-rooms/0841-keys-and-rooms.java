class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Queue<Integer> keys = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        
        for(int key : rooms.get(0))
            keys.offer(key);
        
        visited[0] = true;
        
        while(!keys.isEmpty()){
            int key = keys.poll();
            if(visited[key]) continue;
            
            visited[key] = true;
            
            for(int k : rooms.get(key)){
                if(!visited[k])
                    keys.offer(k);    
            }
            
            
        }
        
        for(boolean visit : visited){
            if(!visit) return false;
        }
        
        return true;
    }
}