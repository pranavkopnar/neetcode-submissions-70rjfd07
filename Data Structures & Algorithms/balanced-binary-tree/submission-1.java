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

        if (root == null) return true;
        
        boolean isBalanced = true;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.getLast();

            if (node.left != null && !map.containsKey(node.left)) {
                stack.add(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.add(node.right);
            } else {
                TreeNode temp = stack.removeLast();

                int leftH = map.get(temp.left);
                int rightH = map.get(temp.right);

                if (Math.abs(leftH - rightH) > 1) return false;

                map.put(temp, 1 + Math.max(leftH, rightH));
            }
        }

        return true;
    }
}
