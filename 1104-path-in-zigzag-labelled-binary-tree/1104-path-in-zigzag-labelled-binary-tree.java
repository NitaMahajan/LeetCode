class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int power = (int)Math.floor(Math.log(label)/Math.log(2));
        List<Integer> path = new ArrayList<>();
        while(power > 0) {
            int sb = (int)Math.pow(2, power), eb = (int)Math.pow(2, power + 1)-1;
            path.add(label);
            label = (int)Math.round((eb - (label - sb))/2); 
            power--;
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}