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

    private record HDPair(int h, int d) {};

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, HDPair> map = new HashMap<>();
        map.put(null, new HDPair(0,0));
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

                int leftH = map.get(node.left).h();
                int rightH = map.get(node.right).h();
                int height = 1 + Math.max(leftH, rightH);

                int leftD = map.get(node.left).d();
                int rightD = map.get(node.right).d();
                int diameter = Math.max(leftH + rightH, Math.max(leftD, rightD));

                map.put(temp, new HDPair(height, diameter));
            }
        }

        return map.get(root).d();
    }

}
