class Solution {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        
        for(int i=1;i<n;i++){
            s = build(s);
        }
        return s.toString();
    }
    
    public StringBuilder build(StringBuilder s){
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length();i++){
            int count = 0;
            char currC = s.charAt(i);

            while(i<s.length() && currC == s.charAt(i)){
                count++;
                i++;
            }
            ans.append(count);
            ans.append(currC);
            i--;
        }
        
        return ans;
    }
}