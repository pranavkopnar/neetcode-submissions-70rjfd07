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

        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        map.put(null, 0);
        stack.add(root);

        TreeNode last = root;

        while (!stack.isEmpty()) {
            TreeNode node = stack.getLast();

            if (node.left != null && !set.contains(node.left)) {
                stack.addLast(node.left);
                node = node.left;
            } else {
                if (node.right == null || set.contains(node.right)) {
                    stack.removeLast();

                    int leftH = map.get(node.left);
                    int rightH = map.get(node.right);

                    if (Math.abs(leftH - rightH) > 1)
                        return false;
                    
                    map.put(node, 1 + Math.max(leftH, rightH));
                    set.add(node);

                } else {
                    stack.addLast(node.right);
                }
            }
        }

        return true;
    }
}
