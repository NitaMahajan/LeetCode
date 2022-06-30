class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, maxLen = 0;
        for(int i=1; i < n-1; i++){
            if((arr[i-1] < arr[i]) && (arr[i] > arr[i+1])) {
                int len = 1;
                int k = i;
                while(k>=1 && arr[k] > arr[k-1]){
                    k--; len++;
                }
                k = i;
                while(k<n-1 && arr[k] > arr[k+1]) {
                    k++; len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}