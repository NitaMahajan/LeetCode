class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i:nums) {
            int freq = count.getOrDefault(i, 0);
            count.put(i, freq + 1);
        }
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int freq = entry.getValue();
            if(freq > 1) return true;
        }
        return false;
    }
}