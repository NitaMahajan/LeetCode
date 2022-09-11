class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int indegree[] = new int[n+1];
        for(int i=0;i<n;i++) {
            adjList.put(i+1, new ArrayList<>());
        }
        // Prepare adjacency list and indegree array 
        for(int i=0;i<relations.length;i++) {
            int prev = relations[i][0], next = relations[i][1];
            adjList.get(prev).add(next);
            indegree[next]++;
        }
       
        // Add indegree 0 nodes inside queue
        int durations[] = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<= n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                durations[i] = time[i-1];
            }
        }
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            for(Integer adj: adjList.get(node)) {
                durations[adj] = Math.max(durations[adj], durations[node] + time[adj-1]);
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }
        int maxDuration = 0;
        for(int i=1;i<=n;i++) maxDuration = Math.max(maxDuration, durations[i]);
        return maxDuration;
    }
}