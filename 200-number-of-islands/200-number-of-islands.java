class Solution {
    int direction[] = {0,1,0,-1,0};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n]; // Keep track of visited nodes
        int components = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    bfs(i, j, grid, m, n);
                    components++;
                }
            }
        }
        return components;
    }
    public void bfs(int row, int col, char[][] grid, int maxRow, int maxCol) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        grid[row][col] = '2';
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currRow = (int)curr.getKey();
            int currCol = (int)curr.getValue();
            for(int i = 0; i < 4; i++) {
                int newRow = currRow + direction[i];
                int newCol = currCol + direction[i+1];
                if(newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol || grid[newRow][newCol]!='1') {
                    continue;
                }
                grid[newRow][newCol] = '2';
                queue.add(new Pair(newRow, newCol));
            }
        }
    }
}