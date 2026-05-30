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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        boolean[] isBalanced = new boolean[]{true};

        dfs(root, isBalanced);

        return isBalanced[0];
        
    }

    public int dfs(TreeNode node, boolean[] isBalanced) {

        if (node == null)
            return 0;

        int leftH = dfs(node.left, isBalanced);
        int rightH = dfs(node.right, isBalanced);
        if (Math.abs(leftH - rightH) > 1)
            isBalanced[0] = false;

        return 1 + Math.max(leftH, rightH);
    }


}
