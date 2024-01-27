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

import java.util.*;

class Solution {
    // DFS
    // public int minDepth(TreeNode root) {
    //     // root 가 null 이면 return 0
    //     if (root == null){
    //         return 0;   
    //     }else if(root.left == null && root.right == null){
    //         return 1;
    //     }else if(root.left == null){
    //         return 1 + minDepth(root.right);
    //     }else if(root.right == null){
    //         return 1 + minDepth(root.left);
    //     }else{
    //         return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    //     }
    // }
    
    // BFS
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                
                if(node.left == null && node.right == null){
                    return depth;
                }
                
                if(node.right != null){
                    q.offer(node.right);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
            }
        }
        return depth;
    }
}