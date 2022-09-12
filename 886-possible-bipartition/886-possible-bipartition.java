class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i < n;i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<dislikes.length;i++) {
            int from = dislikes[i][0], to = dislikes[i][1];
            graph.get(from-1).add(to-1);
            graph.get(to-1).add(from-1);
        }
        int color[] = new int[n];
        for(int i = 0;i < n;i++) {
            if(color[i] != 0) continue;
            color[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                int colorNode = color[node];
                for(Integer adj: graph.get(node)) {
                    if(color[adj] == 0) {
                        color[adj] = (colorNode == 1) ? 2 : 1;
                        queue.offer(adj);
                    } else if(color[adj]==1 && colorNode==1 || color[adj]==2 && colorNode==2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}