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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Boolean> map = new HashMap<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.getLast();
            if (map.get(curr) != null) {
                curr = stack.removeLast();
                list.add(curr.val);
                curr = null;
                continue;
            } else {
                map.put(curr, true);
            }

            curr = curr.right;
            
        }

        return list;
    }
}