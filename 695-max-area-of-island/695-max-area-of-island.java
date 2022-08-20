class Solution {
    int directions[] = {0,1,0,-1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int maxArea = 0;
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if((grid[i][j] == 1) && !visited[i][j]) {
                    int areaOfBfs = bfs(i, j, grid, visited, m, n);
                    maxArea = Math.max(maxArea, areaOfBfs);
                }
            }
        }
        return maxArea;
    }
    public int bfs(int row, int col, int[][] grid, boolean[][] visited, int maxRow, int maxCol) {
        int lengthOfBfs = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            lengthOfBfs++;
            Pair curr = queue.poll();
            int currRow = (int)curr.getKey();
            int currCol = (int)curr.getValue();
            
            for(int i=0;i<4;i++) {
                int newRow = currRow + directions[i];
                int newCol = currCol + directions[i+1];
                if(newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol || grid[newRow][newCol] != 1 || visited[newRow][newCol]) {
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.add(new Pair(newRow, newCol));
            }
        }
        return lengthOfBfs;
    }
}