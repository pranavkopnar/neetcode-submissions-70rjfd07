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
        
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int s = queue.size();
            TreeNode temp = null;
            for (int i=0; i<s; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                temp = node;
            }

            if (temp != null) list.add(temp.val);
        }

        return list;
    }
}
