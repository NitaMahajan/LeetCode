class Solution {
    int directions[] = {0,1,0,-1,0};
    public int[][] updateMatrix(int[][] mat) {
        // Idea: Start BFS from zeros while maintaining cost in matrix for every cell
        int m = mat.length, n = mat[0].length;
        int cost[][] = new int[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n;j++) {
                if(mat[i][j] != 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.add(new Pair(i, j));
                }
            }
        }
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int row = (int)curr.getKey(), col = (int)curr.getValue();
            for(int i=0;i<4;i++) {
                int newRow = directions[i] + row, newCol = directions[i+1] + col;
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || mat[newRow][newCol]!=1) {
                    continue;
                }
                if((cost[row][col]+1) < cost[newRow][newCol]) {
                    cost[newRow][newCol] = (cost[row][col] + 1);
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        return cost;
    }
}