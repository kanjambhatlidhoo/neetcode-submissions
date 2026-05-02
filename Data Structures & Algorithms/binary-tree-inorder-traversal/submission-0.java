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
    List<Integer> inorder;

    public Solution() {
        inorder = new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        this.findInorder(root);

        return this.inorder;
    }

    public void findInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        this.findInorder(root.left);
        this.inorder.add(root.val);
        this.findInorder(root.right);

        return;
    }
}