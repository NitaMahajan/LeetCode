class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashSet<Integer> visited = new HashSet<>(); // Keep track of visited bus routes
        int n = routes.length; // Number of bus routes
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); // Mapping of bus stop -> bus routes
        for(int i=0;i<n;i++) {
            for(int j =0 ; j < routes[i].length; j++) {
                ArrayList<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                map.put(routes[i][j], list);
            }
        }
        int busRouteChangedCounter = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            busRouteChangedCounter++;
            int len = queue.size();
            for(int i=0;i<len;i++) {
                int busStop = queue.poll();
                for(Integer busRoute: map.get(busStop)) {
                    if(visited.contains(busRoute)) continue;
                    visited.add(busRoute);
                    for(int j=0;j<routes[busRoute].length;j++) {
                        if(routes[busRoute][j] == target) {
                            return busRouteChangedCounter;
                        }
                        queue.offer(routes[busRoute][j]);
                    }
                }
            }
        }
        return -1;
    }
}