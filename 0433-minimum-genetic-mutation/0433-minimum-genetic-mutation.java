class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        
        int minMutation = 0;
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] geneTypes = new char[]{'C','G','T','A'};
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        set.add(start);
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                if(curr.equals(end)) return minMutation;

                for(int j=0;j<curr.length();j++){
                    char ch = curr.charAt(j);
                    
                    for(char c : geneTypes){
                        
                        if(c != ch){
                            
                            StringBuilder sb = new StringBuilder(curr);
                            sb.setCharAt(j, c);
                            
                            if(!set.contains(sb.toString()) && bankSet.contains(sb.toString())){
                                queue.offer(sb.toString());
                                set.add(sb.toString());
                            }
                        }
                        
                    }
                    
                }
                
            }
            minMutation++;
        }
        
        return -1;
    }
}