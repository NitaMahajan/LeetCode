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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        for(int i=0;i<list.size()-1;i++) {
            TreeNode curr = list.get(i);
            curr.left = null;
            curr.right = list.get(i+1);
        }
        list.get(list.size()-1).left=null;
        return list.get(0);
    }
    void inorder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
    }
}