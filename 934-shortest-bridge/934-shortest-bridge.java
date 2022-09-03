class Solution {
    int directions[] = {0,1,0,-1,0};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int dist[][] = new int[n][n];
        for(int i=0, found=0 ;i<n;i++) {
            for(int j=0; (found == 0 && (j<n)); j++) {
                if(grid[i][j] == 1) {
                    paint(i,j,n,grid); // Paint the first group of ones(first island) as 2
                    found = 1;
                }
            }
        }
        for(int dis=2;;dis++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == dis) {
                        if(expand(i+1,j,n,grid,dis) || expand(i-1,j,n,grid,dis) || expand(i,j+1,n,grid,dis) || expand(i,j-1,n,grid,dis)) {
                            return grid[i][j]-2;
                        }
                    }
                }
            }
        }
        
    }
    public void paint(int i, int j, int n, int grid[][]) {
        if(i < 0 || i >=n || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        for(int d = 0; d < 4; d++) {
            int adjRow = directions[d] + i, adjCol = directions[d+1] + j;
            paint(adjRow, adjCol,n,grid);
        }
    }
    public boolean expand(int i, int j, int n, int grid[][],int dis) {
        if(i < 0 || i >=n || j < 0 || j >= n) return false;
        grid[i][j] = (grid[i][j] == 0) ? dis + 1: grid[i][j];
        return grid[i][j] == 1;
    }
}