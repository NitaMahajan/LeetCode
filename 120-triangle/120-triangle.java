class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        for(int i = rows - 2; i >=0 ; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> rowBelow = triangle.get(i + 1);
            for(int j = 0; j < row.size(); j++) {
                row.set(j, row.get(j) + Math.min(rowBelow.get(j), rowBelow.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}