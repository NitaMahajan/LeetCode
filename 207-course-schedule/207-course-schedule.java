class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++) {
            int from = prerequisites[i][1], to = prerequisites[i][0];
            list.get(from).add(to);
        }
        
        int visited[] = new int[numCourses];
        int dfsVisited[] = new int[numCourses];
        
        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0) {
                
                if(dfsCycle(i, visited, dfsVisited, list) == true) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfsCycle(int node, int visited[], int dfsVisited[], List<List<Integer>> list) {
        dfsVisited[node] = 1;
        visited[node] = 1;
        List<Integer> neighbors = list.get(node);
        for(Integer adj: neighbors) {
            if(visited[adj] == 0) {
                if(dfsCycle(adj, visited, dfsVisited, list) == true) {
                    return true;
                }
            } else if(dfsVisited[adj] == 1) {
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
    }
    
}