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
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }
    public int convertBST(TreeNode root, int value) {
        if(root == null) return value;
        int valueRight = convertBST(root.right, value);
        root.val = root.val + valueRight;
        return convertBST(root.left, root.val);
    }
}