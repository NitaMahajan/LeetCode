class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        boolean dfsVis[] = new boolean[n];
        boolean isSafe[] = new boolean[n];
        // Set<Integer> safeNodes = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, graph, vis, dfsVis, isSafe);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(isSafe[i]) ans.add(i);
        }
        return ans;
        // Collections.sort(ans);
        // return ans;
    }
    public boolean dfs(int node, int[][] graph, boolean vis[], boolean dfsVis[], boolean isSafe[]) {
        vis[node]=true;
        dfsVis[node]=true;
        if(graph[node].length == 0) { // This is terminal node
            isSafe[node] = true;
            dfsVis[node] = false;
            return true;
        }
        boolean result = true;
        for(int adj:graph[node]) {
            if(dfsVis[adj]) {
                dfsVis[node] = false;
                return false;
            }
            if(vis[adj]) {
                if(!isSafe[adj]) {
                    result = false;
                    break;
                }
            }
            else if(!dfs(adj, graph, vis, dfsVis, isSafe)){
                result = false;
                break;
            }
        }
        if(result) {
            isSafe[node] = true;
        }
        dfsVis[node]=false;
        return result;
    }
}