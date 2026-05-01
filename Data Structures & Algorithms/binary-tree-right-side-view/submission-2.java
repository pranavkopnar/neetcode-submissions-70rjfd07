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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;

        if (depth == list.size()) 
            list.add(root.val);

        dfs(root.right, depth+1, list);
        dfs(root.left, depth+1, list);
    }
}
