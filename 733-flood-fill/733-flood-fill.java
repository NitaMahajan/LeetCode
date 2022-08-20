
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean visited[][] = new boolean[m][n]; // 2d-visited array
        
        Queue<Pair> queue = new LinkedList<>(); // Queue to perform BFS on the 2d-array
        Pair src = new Pair(sr, sc); // We will store Pair inside queue
        visited[sr][sc] = true; // mark first position as visited
        queue.add(src);
        int originalColor = image[sr][sc];

        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            int nodeRow = (int)node.getKey();
            int nodeColumn = (int)node.getValue();
            image[nodeRow][nodeColumn] = color;
            
            // Check above node
            if(nodeRow -1 >= 0 && image[nodeRow-1][nodeColumn] == originalColor) {
                if(!visited[nodeRow-1][nodeColumn]) {
                    visited[nodeRow-1][nodeColumn] = true;
                    queue.add(new Pair(nodeRow-1, nodeColumn));
                }
            }
            // Check below node
            if(nodeRow + 1 < m && image[nodeRow+1][nodeColumn] == originalColor) {
                if(!visited[nodeRow+1][nodeColumn]) {
                    visited[nodeRow+1][nodeColumn] = true;
                    queue.add(new Pair(nodeRow+1, nodeColumn));
                }
            }
            
            // Check left node
            if(nodeColumn - 1 >= 0 && image[nodeRow][nodeColumn-1] == originalColor) {
                if(!visited[nodeRow][nodeColumn-1]) {
                    visited[nodeRow][nodeColumn-1] = true;
                    queue.add(new Pair(nodeRow, nodeColumn-1));
                }
            }
            
            // Check right node
            if(nodeColumn + 1 < n && image[nodeRow][nodeColumn+1] == originalColor) {
                if(!visited[nodeRow][nodeColumn+1]) {
                    visited[nodeRow][nodeColumn+1] = true;
                    queue.add(new Pair(nodeRow, nodeColumn+1));
                }
            }
        }
        return image;
    }
}