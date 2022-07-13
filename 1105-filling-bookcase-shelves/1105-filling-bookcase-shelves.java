class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int m[][] = new int[1001][1001];
        return minHeightShelves(books, m, shelfWidth, 0, 0, 0);
    }
    
    public int minHeightShelves(int[][] b, int[][] m, int max_w, int i ,int w, int h) {
        if (i >= b.length) 
            return h;
        if (m[i][w] == 0) {
            m[i][w] = h + minHeightShelves(b, m, max_w, i + 1, b[i][0], b[i][1]);
            if (w + b[i][0] <= max_w)
                m[i][w] = Math.min(m[i][w], minHeightShelves(b, m, max_w, i + 1, w + b[i][0], Math.max(h, b[i][1])));
        }
        return m[i][w];
    }
}