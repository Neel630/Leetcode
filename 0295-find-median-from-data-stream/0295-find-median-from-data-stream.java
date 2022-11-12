class MedianFinder {
    PriorityQueue<Integer> smallest = new PriorityQueue<>();
    PriorityQueue<Integer> largest = new PriorityQueue<>((a,b)->b-a);
    boolean even = true;
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if(even){
            smallest.add(num);
            largest.add(smallest.poll());
        }else{
            largest.add(num);
            smallest.add(largest.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (smallest.peek() + largest.peek()) / 2.0;
        }
        
        return largest.peek()/1.0; 
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */