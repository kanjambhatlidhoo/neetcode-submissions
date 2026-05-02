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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) {
            return traversal;
        }

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode delim = new TreeNode(-1);

        q.add(root);
        q.add(delim);

        List<Integer> curr = new ArrayList<>();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == delim) {
                if (!q.isEmpty()) {
                    q.add(delim);
                }
                List<Integer> temp = new ArrayList<>(curr);
                traversal.add(temp);
                curr = new ArrayList<>();
            } else {
                curr.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return traversal;
    }
}
