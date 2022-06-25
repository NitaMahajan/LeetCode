class Solution {
    int max;
    public int[][] prepareCompatibilityMatrix(int students[][], int mentors[][]) {
        int m = students.length, n = students[0].length;
        int [][]compatibility = new int[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                int score = 0;
                for(int k = 0; k < n; k++) {
                    if(students[i][k] == mentors[j][k]) score++;
                }
                compatibility[i][j] = score;
            }
        }
        return compatibility;
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean visited[] = new boolean[students.length];
        int compatibilityMatrix[][] = prepareCompatibilityMatrix(students, mentors);
        maxCompatibilitySum(students, mentors, visited, compatibilityMatrix, 0, 0);
        return max;
    }
    public void maxCompatibilitySum(int[][] students, int[][] mentors, boolean[] visited, int[][] computedScore, int studentIndex, int score) {
        if(studentIndex >= students.length) {
            max = Math.max(max, score);
            return;
        }
        for(int i = 0; i < mentors.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                maxCompatibilitySum(students, mentors, visited,computedScore, studentIndex + 1, score + computedScore[studentIndex][i]);
                visited[i] = false;
            }
            
        }
    }
}