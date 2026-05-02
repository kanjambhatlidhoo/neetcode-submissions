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
    int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        return this.build(preorder, inorder, 0, preorder.length);
    }

    TreeNode build(int []preorder, int []inorder, int start, int end) {
        if (start >= end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[this.preIdx]);

        int inIdx = this.find(inorder, root.val, start, end);

        this.preIdx++;

        root.left = this.build(preorder, inorder, start, inIdx);
        root.right = this.build(preorder, inorder, inIdx + 1, end);

        return root;
    }

    int find(int []inorder, int val, int start, int end) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }
}
