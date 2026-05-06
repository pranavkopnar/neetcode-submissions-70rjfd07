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
        
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        int maxDiameter = 0;


        while (!stack.isEmpty()) {
            TreeNode node = stack.getLast();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.add(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.add(node.right);
            } else {
                TreeNode curr = stack.removeLast();

                int leftH = map.get(curr.left);
                int rightH = map.get(curr.right);
                int height = 1 + Math.max(leftH, rightH);
                int diameter = leftH + rightH;
                
                maxDiameter = Math.max(maxDiameter, diameter);

                map.put(curr, height);
            }
        }

        return maxDiameter;
    }
}
