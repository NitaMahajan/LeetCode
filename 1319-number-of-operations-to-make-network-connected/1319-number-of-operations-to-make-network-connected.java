class Solution {
    public int makeConnected(int n, int[][] connections) {
        int numberOfExtraEdges = 0;
        int par[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++) {
            par[i] = i;
            rank[i] = 0;
        }
        if(connections.length < n-1) return -1;
        for(int i=0;i<connections.length;i++) {
            union(connections[i][0],connections[i][1],par,rank);
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int parentIndex = findParent(i, par);
            if(map.get(parentIndex) == null)
                map.put(parentIndex, true);
        }
        return map.size() - 1;
    }
    // Returns true if this edge u->v is a redundant(extra) edge which can be adjusted elsewhere
    public boolean union(int u, int v, int par[], int rank[]) {
        int pU = findParent(u, par);
        int pV = findParent(v, par);
        if(pU == pV) return true;
        if(rank[pU] == rank[pV]) {
            rank[pU]++;
            par[pV] = pU;
        } else if(rank[pU] > rank[pV]) {
            par[pV] = pU;
        } else {
            par[pU] = pV;
        }
        return false;
    }
    public int findParent(int u, int par[]) {
        if(u == par[u]) return u;
        return par[u] = findParent(par[u], par);
    }
}