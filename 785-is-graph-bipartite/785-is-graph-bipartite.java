class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n]; // 0, 1 or 2
        
        for(int i=0;i<n;i++) {
            if(color[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while(!queue.isEmpty()) {
                Integer node=queue.poll();
                int colorNode = color[node];
                for(int adj:graph[node]) {
                    if(color[adj] == 0) {
                        color[adj] = (colorNode == 1) ? 2 : 1;
                        queue.offer(adj);
                    } else if((colorNode == 1 && color[adj] == 1) || (colorNode == 2 && color[adj] == 2)) {
                        return false;
                    } else {
                        continue;
                    }
                }
            }
        }
        return true;
    }
}