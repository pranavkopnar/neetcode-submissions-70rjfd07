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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Deque<TreeNode[]> queue = new ArrayDeque<>();
        queue.add(new TreeNode[]{p,q});

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode[] nodes = queue.removeFirst();
                TreeNode node1 = nodes[0];
                TreeNode node2 = nodes[1];

                if (node1 == null && node2 == null) continue;
                else if (node1 == null || node2 == null || node1.val != node2.val) return false;

                queue.add(new TreeNode[]{node1.left, node2.left});
                queue.add(new TreeNode[]{node1.right, node2.right});
            } 
        }
        

        return true;
    }
}
