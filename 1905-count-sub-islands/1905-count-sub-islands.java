class Solution {
    int directions[] = {0,1,0,-1,0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // Perform bfs over grid 2 and while doing so the corresponding cell should be marked as 1 in grid 1. During single bfs if even single cell is not an island then do not consider this bfs call as subisland.(complete bfs but do not incr)
        int m = grid1.length, n = grid1[0].length;
        boolean visited[][] = new boolean[m][n];
        int countOfSubIslands = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j] && grid2[i][j]==1) {
                    if(bfs(i, j, grid2, visited, m, n, grid1)) countOfSubIslands++;
                }
            }
        }
        return countOfSubIslands;
    }
    public boolean bfs(int r, int c, int[][] grid, boolean[][] vis, int m, int n, int grid1[][]) {
        boolean isSubIsland = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));
        vis[r][c]=true;
        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            int cr = (int)node.getKey();
            int cc = (int)node.getValue();
            if(grid1[cr][cc] != 1) isSubIsland = false;
            for(int i=0;i<4;i++){
                int nr = directions[i]+cr;
                int nc = directions[i+1]+cc;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1 || vis[nr][nc]) {
                    continue;
                }
                vis[nr][nc] = true;
                queue.add(new Pair(nr, nc));
            }
        }
        return isSubIsland;
    }
}