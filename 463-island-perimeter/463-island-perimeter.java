class Solution {
    int directions[] = {0,1,0,-1,0};
    public int islandPerimeter(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int perimeter=0, found=0;
        for(int i=0;i<m;i++) {
            for(int j=0;(found==0) && (j<n);j++) {
                if(grid[i][j] == 1) {
                    perimeter = dfs(i,j,m,n,grid);
                    found=1;
                }
            }
        }
        return perimeter;
    }
    public int dfs(int r, int c, int m, int n, int[][] grid) {
        grid[r][c] = 2; // Mark as visited
        int perimeter = getPerimeter(r,c,m,n,grid);
        for(int i=0;i<4;i++) {
            int nr = directions[i]+r, nc = directions[i+1]+c;
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
            perimeter = perimeter + dfs(nr, nc, m,n,grid);
        }
        return perimeter;
    }
    public int getPerimeter(int i, int j,int m,int n, int[][] grid){
        int zeros = 0;
        for(int d=0;d<4;d++) {
            int nr = directions[d]+i, nc = directions[d+1]+j;
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0) zeros++;
        }
        return zeros;
    }
}