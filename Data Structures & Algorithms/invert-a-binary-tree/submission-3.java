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

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.removeFirst();
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.right = left;
                node.left = right;
                
                if (left != null)
                    queue.add(left);

                if (right != null)
                    queue.add(right);
            }
        }

        return root;

    }
}
