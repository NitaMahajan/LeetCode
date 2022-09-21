class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfs(0, graph, res, path);
					
        return res;
    }
    public void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(nextNode, graph, res, path);
            path.remove(path.size() - 1);
        }
    }
}