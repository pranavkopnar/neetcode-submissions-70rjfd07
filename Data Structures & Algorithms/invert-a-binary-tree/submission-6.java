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
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr;
        stack.addLast(root);

        while (!stack.isEmpty()) {
            curr = stack.removeLast();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null)
                stack.addLast(curr.left);
            if (curr.right != null)
                stack.addLast(curr.right);
        }

        return root;
    }
}
