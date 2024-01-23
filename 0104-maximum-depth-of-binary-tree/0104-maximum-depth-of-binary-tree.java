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
    
    int depth = 0;
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return depth;
        }
        
        searchDepth(root, 1);
        
        return depth;
    }
    
    public void searchDepth(TreeNode root, int count){
        if(root != null){
            depth = Math.max(depth, count++);
            searchDepth(root.left, count);
            searchDepth(root.right, count);
        }
    }
}