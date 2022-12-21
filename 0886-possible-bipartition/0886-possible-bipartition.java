class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n+1];
        
        for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<>(); 
        
        for(int[] dislike : dislikes){
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        
        Integer[] color = new Integer[n+1];
        
        for(int i=1;i<=n;i++){
            if(color[i] ==null && !dfs(graph, color, i, 1)) return false;
        }
        
        return true;
    }
    
    public boolean dfs(List<Integer>[] graph, Integer[] color, int i, int currColor){
        color[i] = currColor;
        
        for(int node : graph[i]){
            
            if(color[node] == null) {
                if(!dfs(graph, color, node, 1 - currColor))
                    return false;
            }
            else if(color[node] == currColor) return false;
        }
        
        return true;
    }
}