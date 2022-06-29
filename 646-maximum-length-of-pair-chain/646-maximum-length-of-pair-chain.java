class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n == 1) return 1;
        
        Arrays.sort(pairs, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++) System.out.print(pairs[i][j]+" ");
            System.out.println();
        }
        int dp [] = new int[n+1];
        dp[n] = 0;
        dp[n-1] = 1;
        
        int max=-1;
        for(int i = n-2; i >= 0; i--) {
            int value=-1;
            for(int j = i+1;j<n;j++) {
                if(pairs[j][0] > pairs[i][1]) {
                    value = Math.max(value, dp[j] + 1);
                }
            }
            if(value==-1){
                dp[i] = 1;
            } else {
                dp[i] = value;
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}