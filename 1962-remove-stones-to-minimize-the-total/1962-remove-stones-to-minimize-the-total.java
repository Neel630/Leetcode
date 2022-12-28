class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        
        int remainingStones = 0;

        for(int i : piles){
            queue.offer(i);
            remainingStones += i;
        }
        
        while(k-->0){
            int num = queue.poll();
            queue.offer(num - num/2);
            remainingStones -= num/2;
        }
        
                
        return remainingStones;
    }
}