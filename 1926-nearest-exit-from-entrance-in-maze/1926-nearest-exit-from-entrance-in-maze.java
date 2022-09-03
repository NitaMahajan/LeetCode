class Solution {
    int directions[] = {0,1,0,-1,0};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length, n = maze[0].length;
        int r=entrance[0], c=entrance[1];
        int cost[][] =new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                cost[i][j] = Integer.MAX_VALUE;
        cost[r][c] = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(r,c));
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currR = (int)curr.getKey(), currC = (int)curr.getValue();
            for(int i=0;i<4;i++) {
                int newR = directions[i]+currR, newC = directions[i+1]+currC;
                if(outOfBounds(newR,newC,m,n) || maze[newR][newC]!='.') continue;
                if((cost[currR][currC]+1) < cost[newR][newC]) {
                    cost[newR][newC] = cost[currR][currC]+1;
                    if(isBoundaryCell(newR,newC,m,n)) {
                        return cost[newR][newC];
                    }
                    queue.add(new Pair(newR, newC));
                }
            }
        }
        return -1;
    }
    public boolean outOfBounds(int i, int j, int m, int n) {
        return (i<0|| j<0|| i>=m ||j>=n);
    }
    public boolean isBoundaryCell(int i, int j, int m, int n) {
        return (i==0||i==m-1||j==0||j==n-1);
    }
}