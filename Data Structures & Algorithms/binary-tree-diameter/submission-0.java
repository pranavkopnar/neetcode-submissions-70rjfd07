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
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        
        int leftH = heightTree(root.left);
        int rightH = heightTree(root.right);
        int d = leftH + rightH;
        int childD = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(d, childD);
    }

    private int heightTree(TreeNode node) {
        if (node == null) 
            return 0;
        return 1 + Math.max(heightTree(node.left), heightTree(node.right)); 
    }
}
