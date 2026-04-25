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
    
    private Map<TreeNode, Boolean> balanced;

    public boolean isBalanced(TreeNode root) {

        balanced = new HashMap<>();
        dfs(root);

        for (Map.Entry<TreeNode, Boolean> entry : balanced.entrySet()) {
            if (!entry.getValue()) return false;
        }

        return true;
    }

    public int dfs(TreeNode root) {
        if (root == null) 
            return 0;

        int leftH = dfs(root.left);
        int rightH = dfs(root.right);
        balanced.put(root, Math.abs(leftH - rightH) <= 1);

        return 1 + Math.max(leftH, rightH);
    }
}
