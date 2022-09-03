class Solution {
    int directions[] = {0,1,0,-1,0};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cache[][]=new int[m][n];
        int max=-1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                max = Math.max(max, dfs(i, j, m, n, matrix, cache));
            }
        }
        return max;
    }
    public int dfs(int r, int c, int m, int n, int [][]matrix, int [][]cache) {
        if(cache[r][c] != 0) return cache[r][c];
        int max=1;
        for(int i=0;i<4;i++) {
            int nr = directions[i]+r, nc = directions[i+1]+c;
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[nr][nc] >= matrix[r][c]) continue;
            max = Math.max(max, dfs(nr, nc, m, n, matrix, cache)+1);
        }
        cache[r][c] = max;
        return max;
    }
}