class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i = n-1; i >=0 ; i--) {
            // cost for 1 day ticket derives from min cost of current day + 1 in days arr
            int cost1 = costs[0] + dp[i+1];
            // cost of 7 day ticket derives from min cost of current day + 7 in days arr
            int cost2 = costs[1] + dp[binarySearch(days, 0, n-1, days[i] + 7 - 1)]; 
            // cost for 30 day ticket derives from min cost of current day + 30 in days arr
            int cost3 = costs[2] + dp[binarySearch(days, 0, n-1, days[i] + 30 - 1)]; 
            dp[i] = Math.min(Math.min(cost1, cost2), cost3);
        }
        return dp[0];
    }
    public int binarySearch(int arr[], int start, int end, int num) {
        if(start > end) return start;
        int mid = (start + end)/2;
        if(arr[mid] == num) return mid + 1;
        if(num < arr[mid]) return binarySearch(arr, start, mid - 1, num);
        return binarySearch(arr, mid + 1, end, num);
    }
}