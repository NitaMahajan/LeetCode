class Solution {
    class Node{
        private int x; 
        private int y; 
        private int d;
        Node(int x, int y, int d) {
            this.x = x; 
            this.y = y; 
            this.d = d;
        }
        int getX(){ return this.x; }
        int getY(){ return this.y; }
        int getD(){ return this.d; }
    }
    
    int directions[] = {0,1,0,-1,0};
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<m;i++) { // Add all land cells to the bfs queue
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Node(i,j,0));
                }
            }
        }
        
        if(queue.size() == m*n) return -1; // If there are no water cells return -1
        
        // Keep track of depth of each water cell so that we can have depth of the farthest water cell by the end of BFS
        int depth = -1; 
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            depth = Math.max(depth, curr.getD());
            for(int i=0;i<4;i++) {
                int nr = directions[i] + curr.getX();
                int nc = directions[i + 1] + curr.getY();
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 1) continue;
                grid[nr][nc] = 1;
                queue.add(new Node(nr, nc, curr.getD() + 1));
            }
        }
        return depth;
    }
}