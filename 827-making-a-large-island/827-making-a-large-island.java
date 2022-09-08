class Solution {
    int d[] = {0,1,0,-1,0};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        // g[i][j] == 1 it means its a 1 not visited
        // g[i][j] == 2 or more it means its visited
        int color = 2;
        int max = 0;
        Map<Integer,Integer> colorToSize = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    int size = dfsColor(i,j,n,grid,color);
                    colorToSize.put(color, size);
                    max = Math.max(max,size);
                    color++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> adjColor = new HashSet<Integer>();
                    for(int k=0;k<4;k++) {
                        int nr = d[k]+i, nc = d[k+1]+j;
                        if(nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 0) continue;
                        adjColor.add(grid[nr][nc]); //2,3,4
                    }
                    int sizeOfIsland = 1;
                    for(Integer islandColor:adjColor) {
                        sizeOfIsland += colorToSize.get(islandColor);
                    }
                    max = Math.max(max, sizeOfIsland);
                }
            }
        }
        return max;
    }
    int dfsColor(int r, int c, int n, int[][] grid, int color) {
        grid[r][c] = color;
        int size = 1;
        for(int i=0;i<4;i++) {
            int nr = d[i]+r, nc = d[i+1]+c;
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
            size += dfsColor(nr,nc,n,grid,color);
        }
        return size;
    }
    
}