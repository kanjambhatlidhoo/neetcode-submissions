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
    int count;

    Solution() {
        this.count = 0;
    }
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        this.check(root, max);

        return this.count;
    }

    void check(TreeNode root, int max) {
        if (root == null) {
            return ;
        }

        if (root.val >= max) {
            this.count++;
            max = root.val;
        }

        this.check(root.left, max);
        this.check(root.right, max);


    }
}
