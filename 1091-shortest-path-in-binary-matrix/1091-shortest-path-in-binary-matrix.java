class Solution {
    int directionsX[] = {0,0,1,-1,1,-1,-1,1};
    int directionsY[] = {-1,1,0,0,-1,1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1; // Edge case
        int cost[][] = new int[n][n];
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++) 
                cost[i][j] = Integer.MAX_VALUE;
        cost[0][0] = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int currRow = (int)pair.getKey(), currCol = (int)pair.getValue();
            for(int i=0;i<8;i++) {
                int adjRow = directionsX[i] + currRow, adjCol = directionsY[i] + currCol;
                if(adjRow < 0 || adjRow >= n || adjCol < 0|| adjCol>=n || grid[adjRow][adjCol] != 0) {
                    continue;
                }
                if((cost[currRow][currCol] + 1) < (cost[adjRow][adjCol])) {
                    cost[adjRow][adjCol] = (cost[currRow][currCol] + 1);
                    queue.add(new Pair(adjRow, adjCol));
                }
            }
        }
        return (cost[n-1][n-1] == Integer.MAX_VALUE) ? -1 : (cost[n-1][n-1]+1);
    }
}