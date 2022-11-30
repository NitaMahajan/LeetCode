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
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,1,1);
    }
    public int sumEvenGrandparent(TreeNode root, int parent, int grandParent) {
        if(root == null) return 0;
        int left = sumEvenGrandparent(root.left, root.val, parent);
        int right = sumEvenGrandparent(root.right, root.val, parent);
        return left + right + (grandParent % 2 == 0 ? root.val : 0);
    }
}