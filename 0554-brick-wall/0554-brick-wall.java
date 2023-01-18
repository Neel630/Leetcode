class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int bricksToNotCut = 0;
        for(List<Integer> bricks: wall){
            int length = 0;
            for(int i=0;i<bricks.size()-1;i++){
                length += bricks.get(i);
                hm.put(length, hm.getOrDefault(length, 0) + 1);
                
                bricksToNotCut = Math.max(bricksToNotCut, hm.get(length));
            }
        }
        
        return wall.size() - bricksToNotCut;
    }
}