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

    public record NodePair(TreeNode node, int height) {}

    public int maxDepth(TreeNode root) {
        
        if (root == null) return 0;

        int max = 0;
        Deque<NodePair> q = new ArrayDeque<>();
        q.add(new NodePair(root, 1));

        while (!q.isEmpty()) {
            NodePair pair = q.removeLast();
            TreeNode node = pair.node();
            int h = pair.height();

            max = Math.max(h, max);

            if (node.left != null) q.add(new NodePair(node.left, h+1));
            if (node.right != null) q.add(new NodePair(node.right, h+1));
        }

        return max;
    }
}
