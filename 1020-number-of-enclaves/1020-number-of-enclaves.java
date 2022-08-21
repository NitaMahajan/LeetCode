class Solution {
    int direction[] = {0,1,0,-1,0};
    public boolean isBoundaryCell(int row, int col, int maxRow, int maxCol) {
        if(row == 0 || row == maxRow-1 || col == 0 || col == maxCol-1) return true;
        return false;
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((!visited[i][j]) && (grid[i][j] == 1) && (isBoundaryCell(i, j, m, n))) {
                    floodFillboundaryOnes(i, j, grid, visited, m, n);
                }
            }
        }
        int maxLen = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) maxLen++;
            }
        }
        return maxLen;
    }
    public int floodFillboundaryOnes(int row, int col, int grid[][], boolean visited[][], int maxRow, int maxCol) {
        Queue<Pair> queue = new LinkedList<>();
        int lengthOfBfs = 0;
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            lengthOfBfs++;
            Pair curr = queue.poll();
            int currRow = (int)curr.getKey();
            int currCol = (int)curr.getValue();
            grid[currRow][currCol] = 0;
            for(int i=0;i<4;i++) {
                int nextRow = currRow + direction[i];
                int nextCol = currCol + direction[i+1];
                if(nextRow<0 || nextRow>=maxRow || nextCol<0 || nextCol>=maxCol || grid[nextRow][nextCol]!=1 || visited[nextRow][nextCol]){
                    continue;
                }
                visited[nextRow][nextCol] = true;
                queue.add(new Pair(nextRow, nextCol));
            }
            
        }
        return lengthOfBfs;
    }
}