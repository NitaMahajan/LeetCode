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
    public int sumOfLeftLeaves(TreeNode root) {
        int ans[] = new int[1];
        sumOfLeftLeaves(root, false, ans);
        return ans[0];
    }
    
    public void sumOfLeftLeaves(TreeNode root, boolean left, int ans[]) {
        if(root == null) return;
        if(left && root.left == null && root.right == null) {
            ans[0] += root.val;
            return;
        }
        sumOfLeftLeaves(root.left, true, ans);
        sumOfLeftLeaves(root.right, false, ans);
    }
}