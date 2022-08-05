class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); // Adjacency list
        int degree[] = new int[numCourses];
        for(int i=0; i < numCourses; i++) { // Initialize an array list for each node
            graph.add(new ArrayList<>());
        }
        for(int i=0;i < prerequisites.length; i++) {
            int from = prerequisites[i][1], to = prerequisites[i][0];
            graph.get(from).add(to); // Prepare a graph
            degree[to]++; // Increase indegree for to node
        }
        Queue<Integer> queue = new LinkedList<Integer>(); // Queue for BFS
        int count = 0; // Count the number of nodes traversed in the topological sort
        // Perform bfs on nodes which have zero indegree
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            for(Integer adj: graph.get(node)) {
                degree[adj]--;
                if(degree[adj] == 0) {
                    queue.add(adj);
                    count++;
                }
            }
        }
        if(count == numCourses) return true;
        return false;
        
    }
    
}