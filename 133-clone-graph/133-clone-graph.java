/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>(); //To store the new nodes
        Queue<Node> queue = new LinkedList<>();
        queue.add(node); // Add first node to the queue
        int visited[] = new int[101];
        visited[node.val] = 1; // Mark first node as visited
        map.put(node.val, new Node(node.val));
        while(!queue.isEmpty()) {
            Node curr = queue.poll(); //FIFO Queue
            Node newCurr = map.get(curr.val);
            for(Node adj: curr.neighbors) {
                // For adjacent neighbours
                if(visited[adj.val] == 1) { // If adj visited, then add the newAdj node from map to the neighbours of newCurr
                    newCurr.neighbors.add(map.get(adj.val));
                } else {
                    // We have to make a newAdj node in map
                    Node newAdj = new Node(adj.val);
                    map.put(adj.val, newAdj);
                    newCurr.neighbors.add(newAdj);
                    visited[adj.val] = 1;
                    queue.add(adj);
                }
            }
        }
        return map.get(node.val);
    }
}