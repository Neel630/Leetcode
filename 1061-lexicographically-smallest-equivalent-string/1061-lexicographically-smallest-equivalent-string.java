class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] graph = new int[26];
        
        for(int i=0;i<26;i++){
            graph[i] = i;
        }
        
        for(int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            int indC1 = find(graph, c1 - 'a');
            int indC2 = find(graph, c2 - 'a');
            
            if(indC1  < indC2){
                graph[indC2] = indC1;
            }else{
                graph[indC1] = indC2;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<baseStr.length();i++){
            sb.append((char)( 'a' + find(graph, baseStr.charAt(i) - 'a')));
        }
        
        return sb.toString();
    }
    
    public int find(int[] graph, int ind){
        while(graph[ind]!=ind){
            ind = graph[ind];
        }
        return ind;
    }
}