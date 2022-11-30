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

class Pair {
    private int child;
    private int grandChild;
    Pair(int child, int grandChild) {
        this.child = child;
        this.grandChild = grandChild;
    }
    int getChild() { return this.child; }
    int getGrandChild() { return this.grandChild; }
}
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int ans[] = new int[1];
        sumEvenGrandparent(root, ans);
        return ans[0];
    }
    public Pair sumEvenGrandparent(TreeNode root, int ans[]) {
        if(root == null) {
            return new Pair(0, 0);
        }
        Pair left = sumEvenGrandparent(root.left, ans);
        Pair right = sumEvenGrandparent(root.right, ans);
        int childSum = left.getChild() + right.getChild();
        int grandChildSum = left.getGrandChild() + right.getGrandChild();
        if(root.val % 2 == 0) {
            ans[0] = ans[0] + grandChildSum;
        }
        return new Pair(root.val, childSum);
    }
}