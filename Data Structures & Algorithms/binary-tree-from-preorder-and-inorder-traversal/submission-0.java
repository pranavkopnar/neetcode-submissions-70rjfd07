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

    private int ind = 0;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }    

        return buildTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int i, int j) {
        if (i > j)
            return null;

        int rootVal = preorder[ind++];
        TreeNode root = new TreeNode(rootVal);
        int m = map.get(rootVal);
        root.left = buildTree(preorder, i, m-1);
        root.right = buildTree(preorder, m+1, j);
        return root;
    }
}
