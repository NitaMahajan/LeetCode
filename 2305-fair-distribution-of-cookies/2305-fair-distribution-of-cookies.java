class Solution {
    int minimisedUnfairness = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int distribution[] = new int[k];
        distributeCookies(cookies, distribution, k, 0);
        return minimisedUnfairness;
    }
    public void distributeCookies(int[] cookies, int[] distribution, int k, int cookieBagIndex) {
        if(cookieBagIndex == cookies.length) { //base case
            minimisedUnfairness = Math.min(minimisedUnfairness, findMax(distribution));
            return;
        }
        for(int i = 0; i < k; i++) { 
            // for each child, give the current cookiebag to it
            distribution[i] += cookies[cookieBagIndex]; 
            // move to the next cookie
            distributeCookies(cookies, distribution, k, cookieBagIndex + 1);
            // now take away the cookie bag from child and give it to next child
            distribution[i] -= cookies[cookieBagIndex];
        }
    }
    public int findMax(int arr[]) {
        int max = -1;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
}