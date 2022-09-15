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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        int i=0,j=0,m=list1.size(),n=list2.size();
        while((i<m) && (j<n)) {
            if(list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }
        while(i<m) {
            list3.add(list1.get(i));
            i++;
        }
        while(j<n) {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if(root != null) {
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
}