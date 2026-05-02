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
    int diameterVal;

    public Solution() {
        this.diameterVal = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        this.diameter(root);

        return this.diameterVal;
    }

    public void diameter(TreeNode root) {
        if (root == null) {
            return ;
        }

        int l = this.height(root.left);
        int r = this.height(root.right);

        this.diameterVal = Math.max(this.diameterVal, l + r);

        this.diameter(root.left);
        this.diameter(root.right);
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
