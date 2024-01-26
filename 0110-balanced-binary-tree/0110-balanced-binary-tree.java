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
        if(root == null){
            return true;
        }
        
        if (search(root, "begin") == -1)  {
            return false;
        }
        
        return true;
    }
    
    public int search(TreeNode root, String type){
        if (root == null){
            return 0;
        }
        int leftHeight = search(root.left, "left");
		int rightHight = search(root.right, "right");
  
		if (leftHeight == -1 || rightHight == -1){
            return -1;
        }
        if (Math.abs(leftHeight - rightHight) > 1){
            return -1;
        }

		return Math.max(leftHeight, rightHight) + 1;
    }
}