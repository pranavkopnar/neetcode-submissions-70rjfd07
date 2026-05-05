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

    public record Node(TreeNode node, int depth) {}

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        
        Deque<Node> stack = new ArrayDeque<>();
        stack.add(new Node(root, 1));

        int ans = 0;

        while (!stack.isEmpty()) {
            Node node = stack.removeLast();
            TreeNode treeNode = node.node();
            int depth = node.depth();

            ans = Math.max(ans, depth);

            if (treeNode.left != null) {
                stack.add(new Node(treeNode.left, 1 + depth));
            }

            if (treeNode.right != null) {
                stack.add(new Node(treeNode.right, 1 + depth));
            }
        }

        return ans;

    }

}
