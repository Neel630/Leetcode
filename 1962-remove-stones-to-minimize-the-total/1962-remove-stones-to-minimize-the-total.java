class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        
        for(int i : piles){
            queue.offer(i);
        }
        
        while(k-->0){
            int num = queue.poll();
            queue.offer(num - num/2);
        }
        
        int remainingStones = 0;
        
        while(!queue.isEmpty()) remainingStones += queue.poll();
        
        return remainingStones;
    }
}