class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, d = Integer.MAX_VALUE, minStart = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int counter=0;
        for(char c : t.toCharArray()){
            hm.put(c, hm.getOrDefault(c , 0)+1);
            counter++;
        }
                
        while(j < s.length()){
            char c = s.charAt(j);
            if(hm.getOrDefault(c, 0) > 0){
                counter--;
            }
            
            hm.put(c, hm.getOrDefault(c, 0) - 1);
            j++;
            
            while(counter == 0){
                char c2 = s.charAt(i); 
                if(d > j-i){
                    d = j - i;
                    minStart = i;
                }
                hm.put(c2, hm.getOrDefault(c2, 0) + 1);
                if(hm.get(c2)>0) counter++;
                i++;
            }
            
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+d);
    }
}