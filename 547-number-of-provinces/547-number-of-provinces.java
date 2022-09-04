class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Simple application of disjoint set/union find algo
        // Number of provinces would be the unique parents in parents array
        int n = isConnected.length;
        int par[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++) {
            par[i] = i;
            rank[i] = 0;
        }
        for(int i=0;i<n;i++) {
            for(int j=0; j < n;j++) {
                if(isConnected[i][j] == 1) {
                    union(i, j, par, rank);
                }
            }
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(findParent(par[i], par), true);
        }
        return map.size();
    }
    public void union(int u, int v, int par[], int rank[]){
        int parU = findParent(u, par);
        int parV = findParent(v, par);
        if(parU == parV) return;
        if(rank[parU] > rank[parV]) {
            par[parV] = parU;
        } else if(rank[parU] < rank[parV]) {
            par[parU] = parV;
        } else {
            rank[parU]++;
            par[parV] = parU;
        }
    }
    public int findParent(int u, int par[]) {
        if(par[u] == u) return u;
        return par[u] = findParent(par[u], par);
    }
}