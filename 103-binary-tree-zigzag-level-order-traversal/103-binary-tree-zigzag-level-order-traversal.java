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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        boolean forward = true;
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            if(forward) {
                for(int i=0;i<len;i++) {
                    TreeNode node = queue.poll();
                    levelNodes.add(node.val);
                    if(node.left != null)
                        stack.push(node.left);
                    if(node.right != null)
                        stack.push(node.right);
                }
            } else {
                for(int i=len-1;i>=0;i--) {
                    TreeNode node = queue.poll();
                    levelNodes.add(node.val);
                    if(node.right != null)
                        stack.push(node.right);
                    if(node.left != null)
                        stack.push(node.left);
                }
            }
            traversal.add(levelNodes);
            while(!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
            forward = !forward;
        }
        return traversal;
    }
}