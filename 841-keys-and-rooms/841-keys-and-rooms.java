class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        dfs(0, rooms, vis);
        for(int i=0;i<n;i++) {
            if(!vis[i]) return false;
        }
        return true;
    }
    void dfs(int room, List<List<Integer>> rooms, boolean vis[]) {
        vis[room] = true;
        for(Integer adj: rooms.get(room)) {
            if(vis[adj]) continue;
            dfs(adj, rooms, vis);
        }
    }
}