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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !queue.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                queue.add(curr);
                curr = curr.left;
            }

            curr = queue.removeLast();
            curr = curr.right;
        }

        return list;
    }
}