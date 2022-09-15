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
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }
    public int bstToGst(TreeNode root, int sum) {
        if(root == null) return sum;
        int res = bstToGst(root.right, sum);
        root.val = root.val + res;
        return bstToGst(root.left, root.val);
    }
}