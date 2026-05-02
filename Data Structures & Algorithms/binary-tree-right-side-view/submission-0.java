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
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> rightView = new ArrayList<>();

        TreeNode delim = new TreeNode(-1);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(delim);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == delim) {
                if (!q.isEmpty()) {
                    q.add(delim);
                }
            }

            else {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }

                // check for delimiter.
                if (q.peek() == delim) {
                    rightView.add(curr.val);
                }
            }
        }

        return rightView;
    }
}
