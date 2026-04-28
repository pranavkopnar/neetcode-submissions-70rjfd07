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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.removeFirst();
                if (dfs(node, subRoot)) {
                    return true;
                }
                if (node.left != null) queue.add(node.left);
                else if (node.right != null) queue.add(node.right);
            }
        }

        return false;
    }

    private boolean dfs(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        else if (node == null || subRoot == null || node.val != subRoot.val) return false;

        return dfs(node.left, subRoot.left) && dfs(node.right, subRoot.right);
    }
}
