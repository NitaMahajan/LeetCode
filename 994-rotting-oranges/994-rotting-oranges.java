class Solution {
    class Node{
        private int x, y, d;
        Node(int x, int y, int d) {
            this.x = x; this.y = y; this.d = d;
        }
        int getX() { return this.x; }
        int getY() { return this.y; }
        int getD() { return this.d; }
    }
    int directions[] = {0,1,0,-1,0};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        boolean freshOrangesExist = false;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) freshOrangesExist=true;
                if(grid[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        if(queue.size() == 0 && !freshOrangesExist) return 0;
        if(queue.size() == 0 && freshOrangesExist) return -1; // There are no rotten oranges, then its not possible so return -1;
        int depth=0;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int r = curr.getX(), c = curr.getY(), dist = curr.getD();
            depth = Math.max(depth, dist);
            for(int i=0;i<4;i++) {
                int nr = directions[i] + r, nc = directions[i+1] + c;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
                grid[nr][nc]=2;
                queue.add(new Node(nr, nc, dist+1));
            }
        }
        int countOfFresh = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    countOfFresh++;
                }
            }
        }
        if(countOfFresh > 0) return -1;
        else if(depth > 0) return depth;
        return 0;
    }
}