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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        search(root, res);
        return res;
    }

    public void search(TreeNode root, List<Integer> res) {
        if (root != null) {
            // 왼쪽 먼저 등록
            search(root.left, res);
            res.add(root.val);
            // 왼쪽이 끝나면 오른쪽 등록
            search(root.right, res);
        }
    }
}