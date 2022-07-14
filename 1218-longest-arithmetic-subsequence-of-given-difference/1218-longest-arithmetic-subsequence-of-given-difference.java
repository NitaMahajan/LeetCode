class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for(int num: arr) {
            int val = map.getOrDefault(num - difference, 0);
            map.put(num, val + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}