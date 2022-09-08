class Solution {
    int d[] = {0,1,0,-1,0};
    public int countServers(int[][] grid) {
        int m=grid.length, n = grid[0].length;
        int cols[] = new int[n];
        int rows[] = new int[m];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1){
                    cols[j]++; rows[i]++;
                }
            }
        }
        int connected = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1 && (cols[j]>1||rows[i]>1)) connected++;
            }
        }
        return connected;
    }
}