class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.putIfAbsent(num, 1);
        }
        int maxLen = 0;
        for(int num: nums) {
            if(!map.containsKey(num - 1)){
                int count=0;
                int j=num;
                while(map.get(j) != null) {
                    j++; count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}