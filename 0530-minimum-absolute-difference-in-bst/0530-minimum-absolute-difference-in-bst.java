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
    int minDiff = 100001;
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        getMinDifference(root);
        return minDiff;
    }
    public void getMinDifference(TreeNode root) {
        if(root == null) return;
        getMinimumDifference(root.left);
        if(prev == -1) {
            prev = root.val;
        } else {
            minDiff = Math.min(minDiff, root.val - prev);
            prev = root.val;
        }
        getMinimumDifference(root.right);
    }
}