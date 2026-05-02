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
    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        this.res = root.val;

        this.dfs(root);

        return this.res;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l_val = this.dfs(root.left);
        int r_val = this.dfs(root.right);

        l_val = Math.max(l_val, 0);
        r_val = Math.max(r_val, 0);

        /** there are two splits: one with the node as central node from where split
        is considered, and one simply where the value is returned back to the parent node and 
        no split is considered.
        **/

        this.res = Math.max(this.res, root.val + l_val + r_val);

        return root.val + Math.max(l_val, r_val);

    }


}
