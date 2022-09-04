class Solution {
    int d[]={0,1,0,-1,0};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean skip[][] = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O' && (i==0||j==0||i==m-1||j==n-1)) {
                    dfs(i, j, m, n, board, skip);
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O' && !skip[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int r,int c,int m,int n, char board[][], boolean skip[][]) {
        skip[r][c] = true;
        for(int i=0;i<4;i++){
            int nr=d[i]+r, nc=d[i+1]+c;
            if(nr<0||nr>=m||nc<0||nc>=n||board[nr][nc]!='O'||skip[nr][nc]) continue;
            dfs(nr, nc, m,n, board,skip);
        }
    }
}