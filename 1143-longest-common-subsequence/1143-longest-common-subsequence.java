class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        if(n == 1) { // Special handling for length 1
            return (text2.indexOf(text1.charAt(0))) > -1 ? 1 : 0;
        } else if(m == 1) {
            return (text1.indexOf(text2.charAt(0))) > -1 ? 1 : 0;
        }
        int matrix[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
            }
        }
        return matrix[n][m];
    }
}