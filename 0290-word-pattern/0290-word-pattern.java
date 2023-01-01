class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        HashMap<Character,String> hm = new HashMap<>();
        
        if(sArr.length != pattern.length()) return false;
        
        for(int i=0;i<sArr.length;i++){
            if(hm.containsKey(pattern.charAt(i))){
                
                if(!hm.get(pattern.charAt(i)).equals(sArr[i])) return false;
                continue;
            }
            if(hm.containsValue(sArr[i]))
                    return false;
            hm.put(pattern.charAt(i), sArr[i]);
        }
        
        return true;
    }
}