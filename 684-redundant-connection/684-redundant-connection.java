class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // The idea is to do union for every edge while maintaining rank and parent array
        // When we come across an edge(u-> v) for which the parent(u) and parent(v) is the same
        // then it means this edge can be removed
        // also it is guaranteed this will be last edge from input that can be removed
        int n = edges.length;
        int rank[] = new int[n+1];
        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i=0;i<edges.length;i++) {
            if(union(edges[i][0],edges[i][1], parent, rank)) {
                return edges[i];
            }
        }
        return new int[2];
    }
    public boolean union(int u, int v, int par[], int rank[]) {
        int parU = findParent(u, par);
        int parV = findParent(v, par);
        if(parU == parV) {
            return true;
        }
        if(rank[parU] > rank[parV]) {
            par[parV] = parU;
        } else if(rank[parU] < rank[parV]) {
            par[parU] = parV;
        } else {
            rank[parU]++;
            par[parV] = parU;
        }
        return false;
    }
    public int findParent(int u, int par[]) {
        if(u == par[u]) {
            return u;
        }
        par[u] = findParent(par[u], par);
        return par[u];
    }
}