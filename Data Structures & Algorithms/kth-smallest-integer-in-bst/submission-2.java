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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[2];
        kthSmallest(root, k, count);
        return count[1];
    }

    public void kthSmallest(TreeNode node, int k, int[] count) {
        if (node == null || count[0] == k)
            return;


        kthSmallest(node.left, k, count);
        if (count[0] != k) {
            count[0]++;
            count[1] = node.val;
        }
        kthSmallest(node.right, k, count);
    }

}
