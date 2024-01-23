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
    public boolean isSymmetric(TreeNode root) {
        // 최상단이 null 이면 true
        if (root == null) {
            return true;
        }
        // 왼쪽 노드와 오른쪽 노드 비교하기
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        // 둘다 null 이면 True
        if (node1 == null && node2 == null) {
            return true;
        }
        // 한쪽만 null 이면 False
        else if (node1 == null || node2 == null) {
            return false;
        }
        // 왼쪽  오른쪽 값 비교 그리고 다음 노드들의 대칭 비교 결과
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}