
class Solution {
    int[] direction = {0, 1, 0 , -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        int m = image.length, n = image[0].length;
        
        Queue<Pair> queue = new LinkedList<>(); // Queue to perform BFS on the 2d-array
        Pair src = new Pair(sr, sc); // We will store Pair inside queue
        queue.add(src);
        int originalColor = image[sr][sc];

        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            int nodeRow = (int)node.getKey();
            int nodeColumn = (int)node.getValue();
            image[nodeRow][nodeColumn] = color;
            
            for(int i=0;i<4;i++) {
                int newRow = nodeRow + direction[i];
                int newColumn = nodeColumn + direction[i+1];
                if(newRow < 0 || newRow >= m || newColumn < 0 || newColumn >= n || image[newRow][newColumn] != originalColor) continue;
                queue.add(new Pair(newRow, newColumn));
            }
        }
        return image;
    }
}