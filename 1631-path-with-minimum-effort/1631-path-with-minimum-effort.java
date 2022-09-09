class Solution {
    int distances[]={0,1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++) 
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0));
        dist[0][0]=0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int d = node.getHeight(), r = node.getRow(), c = node.getCol();
            if(d > dist[r][c]) continue; //Outdated so ignore
            if(r == m-1 && c == n-1) return d; // Once reach destination return
            for(int i=0;i<4;i++) {
                int nr=distances[i]+r, nc=distances[i+1]+c;
                if(nr < 0 || nr >= m || nc < 0 || nc >=n) continue;
                int newDist = Math.max(d, Math.abs(heights[nr][nc]-heights[r][c]));
                if(newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;
                    pq.offer(new Node(nr,nc,dist[nr][nc]));
                }
            }
        }
        return 0;
    }
}
class Node implements Comparable<Node> {
    private int row,col,height;
    Node(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
    public int getRow(){ return this.row; }
    public int getCol(){ return this.col; }
    public int getHeight(){ return this.height; }
    public int compareTo(Node n2) {
        if(this.getHeight() < n2.getHeight()) return -1;
        if(this.getHeight() > n2.getHeight()) return 1;
        return 0;
    }
}