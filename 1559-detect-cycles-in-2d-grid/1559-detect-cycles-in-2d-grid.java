class Solution {
    int d[]={0,1,0,-1,0};
    public boolean containsCycle(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean vis[][] = new boolean[m][n];
        boolean cyclePresent=false;
        for(int i=0;i<m;i++) {
            for(int j=0;(!cyclePresent && (j<n));j++) {
                if(!vis[i][j]) {
                    if(dfs(i,j,-1,-1,m,n,grid,vis)) {
                        cyclePresent = true;
                    }
                }
            }
        }
        return cyclePresent;
    }
    public boolean dfs(int r, int c, int pr, int pc, int m, int n, char grid[][], boolean vis[][]) {
        vis[r][c] = true;
        boolean cycle=false;
        for(int i=0;i<4;i++) {
            int nr=d[i]+r, nc=d[i+1]+c;
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != grid[r][c] || (vis[nr][nc] && ((nr == pr) && (nc == pc)))) continue;
            if(vis[nr][nc] && (nr != pr || nc != pc)) return true;
            if(dfs(nr,nc,r,c,m,n,grid,vis)){
                cycle = true;
                break;
            }
        }
        return cycle;
    }
}