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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return maxAncestorDiff(root, root.val, root.val);
    }
    public int maxAncestorDiff(TreeNode root, int min, int max) {
        if(root == null) return -1;
        int val = Math.max(Math.abs(root.val - min),Math.abs(root.val-max));
        int left = maxAncestorDiff(root.left, Math.min(min, root.val), Math.max(max, root.val));
        int right = maxAncestorDiff(root.right, Math.min(min, root.val), Math.max(max, root.val));
        return Math.max(val, Math.max(left, right));
    }
}