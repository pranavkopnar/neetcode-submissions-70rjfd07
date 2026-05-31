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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] indices = new int[2];

        return buildTree(preorder, inorder, indices, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int[] indices, int max) {
        if (indices[0] == preorder.length) {
            return null;
        }

        if (inorder[indices[1]] == max) {
            indices[1]++;
            return null;
        }


        TreeNode node = new TreeNode(preorder[indices[0]++]);
        node.left = buildTree(preorder, inorder, indices, node.val);
        node.right = buildTree(preorder, inorder, indices, max);
        return node;
    }
}
