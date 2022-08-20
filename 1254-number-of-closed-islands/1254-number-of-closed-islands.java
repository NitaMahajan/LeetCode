class Solution {
    int direction[] = {0,1,0,-1,0};
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && (grid[i][j] == 0) && !visited[i][j]) {
                    fillOnesOnBoundaryIslands(i, j, grid, visited, m, n);
                }
            }
        }
        int components = 0;
        for(int i=0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    fillOnesOnBoundaryIslands(i, j, grid, visited, m, n);
                    components++;
                }
            }
        }
        return components;
    }
    public void fillOnesOnBoundaryIslands(int row, int col, int grid[][], boolean[][] visited, int maxRow, int maxCol) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currRow = (int)curr.getKey();
            int currCol = (int)curr.getValue();
            grid[currRow][currCol] = 1;
            for(int i=0;i<4;i++) {
                int newRow = currRow + direction[i];
                int newCol = currCol + direction[i+1];
                if(newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol || grid[newRow][newCol] != 0 || visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.add(new Pair(newRow, newCol));
            }
        }
    }
}