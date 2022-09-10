class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int dist[] = new int[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int startX = points[0][0], startY = points[0][1];
        pq.offer(new Node(0,startX,startY,0));
        dist[0]=0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.getIndex(), nodeX = node.getX(), nodeY = node.getY();
            if(vis[index]) continue; // Skip if current node already visited
            vis[index] = true; // Mark current node as visited
            for(int i=0;i<n;i++) {
                int adjX = points[i][0], adjY = points[i][1];
                if(adjX == nodeX && adjY == nodeY) continue; // Skip if its the same node
                if(vis[i]) continue; // Skip if adjacent node already visited
                int distance = Math.abs(nodeX - adjX) + Math.abs(nodeY - adjY); // Calculate Manhattan dis
                if(dist[i] > distance) {
                    dist[i] = distance;
                    pq.offer(new Node(i,adjX,adjY,distance));
                }
            }
        }
        int minCost = 0;
        for(int i=0;i<n;i++) minCost += dist[i];
        return minCost;
    }
}
class Node implements Comparable<Node>{
    private int index, x, y, dis;
    Node(int index, int x, int y, int dis) {
        this.index = index; this.x = x; this.y = y; this.dis = dis;
    }
    int getIndex() { return this.index; }
    int getX() { return this.x; }
    int getY() { return this.y; }
    int getDis() { return this.dis; }
    public int compareTo(Node n) {
        if(this.getDis() < n.getDis()) return -1;
        if(this.getDis() > n.getDis()) return 1;
        return 0;
    }
}