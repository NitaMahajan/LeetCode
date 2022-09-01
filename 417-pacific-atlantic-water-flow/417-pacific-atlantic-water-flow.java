class Solution {
    int directions[]= {0,1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean visPacific[][] = new boolean[m][n];
        boolean visAtlantic[][] = new boolean[m][n];
        // Perform dfs over cells on boundary of pacific ocean
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if((i == 0 || j == 0) && !visPacific[i][j]) {
                    dfs(i, j, m,n,visPacific, heights);
                }
            }
        }
        // Perform dfs over cells on boundary of atlantic ocean 
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if((i == m-1 || j == n-1) && !visAtlantic[i][j]) {
                    dfs(i, j, m, n, visAtlantic, heights);
                }
            }
        }
        List<List<Integer>> coordinates = new ArrayList<>();
        // Take cells commonly marked in both visited array
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visPacific[i][j] && visAtlantic[i][j]) {
                    List<Integer> xy = new ArrayList<>(2);
                    xy.add(i); xy.add(j);
                    coordinates.add(xy);
                }
            }
        }
        return coordinates;
    }
    public void dfs(int row, int col, int m, int n, boolean [][]vis, int [][]heights){ 
        vis[row][col] = true;
        for(int i=0;i<4;i++) {
            int newRow = directions[i] + row, newCol = directions[i+1] + col;
            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >=n || vis[newRow][newCol] || (heights[newRow][newCol] < heights[row][col])) {
                continue;
            }
            dfs(newRow, newCol, m,n,vis, heights);
        }
    }
}