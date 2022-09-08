
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            int u=times[i][0], v=times[i][1], w=times[i][2];
            adjList.get(u).add(new Node(v,w));
        }
        int distance[] = new int[n+1];
        for(int i = 0; i<=n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k]=0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n);
        pq.add(new Node(k, 0)); // node->cost

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            for(Node next: adjList.get(curr.getV())) {
                if((distance[curr.getV()] + next.getW()) < (distance[next.getV()])) {
                    distance[next.getV()] = (curr.getW() + next.getW());
                    pq.add(new Node(next.getV(), distance[next.getV()]));
                }
            }
        }
        int maxDistance = -1;
        for(int i=1;i<=n;i++) {
            if(distance[i] != Integer.MAX_VALUE)
                maxDistance = Math.max(maxDistance, distance[i]);
            else return -1;
        }
        return maxDistance;
    }
}
class Node implements Comparable<Node>{
    private int v;
    private int w;
    Node(int v, int w){
        this.v = v; this.w=w;
    }
    public int getV() { return this.v; }
    public int getW() { return this.w; }
    public int compareTo(Node n2){
        if(this.getW() < n2.getW()) return -1;
        if(this.getW() > n2.getW()) return 1;
        return 0;
    }
}