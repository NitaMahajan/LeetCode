class Solution {
    int DIR[] = {0,1,0,-1,0};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int indegree[][] = new int[m][n];
        Queue<Node> queue = new LinkedList<>();
        // Prepare Indegree Matrix and Push 0 Indegree Nodes to queue
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                for(int d=0;d<4;d++) {
                    int r = DIR[d]+i, c = DIR[d+1]+j;
                    if(r < 0 || r >= m || c < 0 || c >= n) continue;
                    if(matrix[r][c] < matrix[i][j]) 
                        indegree[i][j]++;
                }
                if(indegree[i][j] == 0) {
                    queue.offer(new Node(i,j,1));
                }
            }
        }
        int maxDistance = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX(), y = node.getY(), dis = node.getDis();
            maxDistance = Math.max(maxDistance, dis);
            for(int d=0;d<4;d++) {
                int r = DIR[d]+x, c = DIR[d+1]+y;
                if(r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[x][y]) continue;
                indegree[r][c]--;
                if(indegree[r][c] == 0) {
                    queue.offer(new Node(r,c,dis+1));
                }
            }
        }
        return maxDistance;
    }
}
class Node {
    private int x,y,dis;
    Node(int x, int y, int dis) {
        this.x = x; this.y = y; this.dis = dis;
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getDis(){ return this.dis; }
}