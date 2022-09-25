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
class Node {
    TreeNode node;
    int index;
    Node(TreeNode node, int index) {
        this.node = node; 
        this.index = index;
    }
    public TreeNode getNode(){ return this.node; }
    public int getIndex(){ return this.index; }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        int maxWidth = 1;
        while(!queue.isEmpty()) {
            int first=0, last=0;
            int minIndex = 3001;
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Node node = queue.poll();
                TreeNode curr = node.getNode();
                int index = node.getIndex();
                minIndex = Math.min(minIndex, index);
                if(i==0) first=index;
                if(i==len-1) last=index;
                if(curr.left != null) {
                    queue.offer(new Node(curr.left, index*2+1));
                }
                if(curr.right != null) {
                    queue.offer(new Node(curr.right, index*2+2));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}