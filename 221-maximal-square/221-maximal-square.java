class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int maxLen = 0;
        int dp[] = new int[m];
        for(int i = 0;i < m;i++) {
            dp[i] = (matrix[n-1][i] == '1') ? 1: 0;
        }
        if(n == 1) {
            for(int j=0;j<m;j++){
                if(matrix[0][j] == '1') return 1;
            }
        }
        for(int i = n-2; i>=0; i--) {
            int temp[] = new int[m];
            for(int j = m-1;j>=0;j--) {
                if(j == m-1) {
                    temp[j]= matrix[i][j] == '1' ? 1:0;
                    maxLen = Math.max(Math.max(temp[j], maxLen),dp[j]);
                }
                else if(matrix[i][j] == '1'){
                    temp[j] = Math.min(Math.min(temp[j+1], dp[j]),dp[j+1])+1;
                }
                else {
                    temp[j] = 0;
                }
                maxLen = Math.max(maxLen, temp[j]);
            }
            dp = temp;
        }
        return maxLen*maxLen;
    }
}