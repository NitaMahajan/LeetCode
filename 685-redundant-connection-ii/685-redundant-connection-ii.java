class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // Three cases
        // 1. One node has two incoming edges and no cycle, in this case remove e2 edge
        // 2. One node has two incoming edges and cycle, in this case remove e2 if there is no cycle (last is occupied) (after skipping e2) else if cycle persist then remove e1
        // 3. Root node has two incoming edges, in this case remove last edge index
        
        int n = edges.length;
        
        int parentEdgeIndex[] = new int[n+1];
        Arrays.fill(parentEdgeIndex, -1);
        
        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++) parent[i] = i;
        
        int first = -1, second = -1, last = -1;
        for(int i=0;i<n;i++) {
            int u = edges[i][0], v = edges[i][1];
            if(parentEdgeIndex[v] != -1) {
                first = parentEdgeIndex[v];
                second = i;
                continue;
            }
            parentEdgeIndex[v]=i;
            int parentOfU = findParent(u, parent);
            if(parentOfU == v) {
                last = i;
            } else {
                parent[v]=parentOfU;
            }
        }
        if(last == -1) return edges[second]; // First case and second case after skipping e2 successfully
        if(second == -1) return edges[last]; // Third case
        return edges[first]; // Second case after skipping e2 unsuccessfully
    }
    public int findParent(int u, int par[]) {
        if(u == par[u]) return u;
        return par[u] = findParent(par[u], par);
    }
}