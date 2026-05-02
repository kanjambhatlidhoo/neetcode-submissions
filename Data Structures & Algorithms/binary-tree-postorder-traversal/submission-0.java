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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();

        this.postorderTraversal(root, postorder);

        return postorder;
    }

    public void postorderTraversal(TreeNode root, ArrayList<Integer> postorder) {
        if (root == null) {
            return;
        }

        this.postorderTraversal(root.left, postorder);
        this.postorderTraversal(root.right, postorder);
        postorder.add(root.val);
    }
}