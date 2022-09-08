class Node implements Comparable<Node> {
    private int node, weight;
    Node(int n, int w) {
        this.node=n; this.weight=w;
    }
    public int getNode(){ return this.node; }
    public int getWeight(){ return this.weight; }
    public int compareTo(Node n2){
        if(this.getWeight() < n2.getWeight()) return -1;
        if(this.getWeight() > n2.getWeight()) return 1;
        return 0;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) 
            adjList.add(new ArrayList<Node>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0], v=edges[i][1], w=edges[i][2];
            adjList.get(u).add(new Node(v,w));
            adjList.get(v).add(new Node(u,w));
        }
        int distances[][] = new int[n][n];
        initialize(distances);
        for(int i=0;i<n;i++) {
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(i,0));
            while(!pq.isEmpty()) {
                Node node=pq.poll();
                for(Node adjEdge: adjList.get(node.getNode())) {
                    if((distances[i][node.getNode()] + adjEdge.getWeight()) > distanceThreshold) continue;
                    if((distances[i][node.getNode()] + adjEdge.getWeight()) < distances[i][adjEdge.getNode()]) {
                        distances[i][adjEdge.getNode()] = (distances[i][node.getNode()] + adjEdge.getWeight());
                        pq.add(new Node(adjEdge.getNode(), distances[i][adjEdge.getNode()]));
                    }
                }
            }
        }
        int smallestCityIndex = -1, smallestCityCount = n+1;
        for(int i=0;i<n;i++) {
            int count = -1;
            for(int j=0;j<n;j++) {
                if(distances[i][j] != Integer.MAX_VALUE) { count++; }
            }
            if(count <= smallestCityCount) {
                smallestCityCount = count; smallestCityIndex = i;
            }
        }
        return smallestCityIndex;
    }
    public void initialize(int dis[][]) {
        for(int i=0;i<dis.length;i++) {
            for(int j=0;j<dis[0].length;j++) {
                if(i!=j) {
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }
        }
    }
}
