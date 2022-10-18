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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, new StringBuilder(""), paths);
        return paths;
    }
    public void binaryTreePaths(TreeNode root, StringBuilder path, List<String> paths) {
        
        if(root == null) return;
        path.append("->"+root.val);
        if(root.left == null && root.right == null) {
            paths.add(path.substring(path.indexOf(">")+1, path.length()));
        }
        if(root.left != null) binaryTreePaths(root.left, path, paths);
        if(root.right != null) binaryTreePaths(root.right, path, paths);
        path.delete(path.lastIndexOf(">")-1, path.length());
    }
}