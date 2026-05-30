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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = new TreeNode(val);

        if (root == null)
            return node;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.removeLast();

            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                } else {
                    stack.addLast(curr.left);
                }
            } else {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                } else {
                    stack.addLast(curr.right);
                }
            }
        }

        return root;
    }
}