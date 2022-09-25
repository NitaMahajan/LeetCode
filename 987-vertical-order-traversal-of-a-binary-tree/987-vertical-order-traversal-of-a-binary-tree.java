/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node{
    private TreeNode node;
    private int offset;
    Node(TreeNode node, int offset) {
        this.node = node;
        this.offset = offset;
    }
    TreeNode getNode(){ return this.node; }
    int getOffset(){ return this.offset; }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while(!queue.isEmpty()) {
            int len = queue.size();
            Map<Integer, List<Integer>> mapTmp = new TreeMap<>();
            for(int i=0;i<len;i++) {
                Node node = queue.poll();
                TreeNode curr = node.getNode();
                int offset = node.getOffset();
                addEntry(mapTmp, offset, curr.val);
                if(curr.left != null)
                    queue.offer(new Node(curr.left, offset-1));
                if(curr.right != null)
                    queue.offer(new Node(curr.right, offset+1));
            }
            for(Map.Entry<Integer, List<Integer>> entry:mapTmp.entrySet()) {
                // System.out.println(entry.getKey());
                // System.out.println(entry.getValue());
                if(entry.getValue() != null) {
                    List<Integer> values=map.getOrDefault(entry.getKey(), new ArrayList<Integer>());
                    values.addAll(entry.getValue());
                    map.put(entry.getKey(), values);
                }
                
            }
        }
        return new ArrayList(map.values());
    }
    public void addEntry(Map<Integer, List<Integer>> map, int key, int value) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
        list.add(value);
        Collections.sort(list);
        map.put(key, list);
    }
}