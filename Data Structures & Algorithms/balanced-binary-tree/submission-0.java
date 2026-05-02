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
    private boolean isBal;

    public Solution() {
        this.isBal = true;
    }

    public boolean isBalanced(TreeNode root) {
        this.check(root);

        return this.isBal;
    }

    public TreeNode check(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = this.check(root.left);
        TreeNode right = this.check(root.right);

        int l_height = this.height(left);
        int r_height = this.height(right);

        if (Math.abs(l_height - r_height) > 1) {
            this.isBal = false;
        }

        return root;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = this.height(root.left);
        int r = this.height(root.right);

        return 1 + Math.max(l, r);
    }
}
