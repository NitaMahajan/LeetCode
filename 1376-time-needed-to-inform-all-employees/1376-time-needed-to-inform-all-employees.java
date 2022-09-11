class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int distances[] = new int[n];
        for(int i = 0; i < n; i++) 
            graph.put(i, new ArrayList<>());
        for(int i=0;i<n;i++) {
            if(manager[i] == -1) 
                continue;
            graph.get(manager[i]).add(i);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(headID);
        distances[headID] = informTime[headID];
        int maxDis=0;
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            maxDis = Math.max(maxDis, distances[curr]);
            for(Integer adj: graph.get(curr)) {
                distances[adj] = distances[curr] + informTime[adj];
                queue.add(adj);
            }
        }
        return maxDis;
    }
}