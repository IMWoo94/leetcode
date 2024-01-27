# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import queue

class Solution:
    # DFS
#     def minDepth(self, root: Optional[TreeNode]) -> int:
#         if not root:
#             return 0
        
#         left = self.minDepth(root.left)
#         right = self.minDepth(root.right)
        
#         if not left and not right:
#             return 1
        
#         if not left:
#             return 1 + right;
        
#         if not right:
#             return 1 + left;
        
#         return min(left, right) + 1
    
    # BFS
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        
        q = queue.Queue()
        q.put(root)
        depth = 0
        
        while not q.empty():
            size = q.qsize()
            depth += 1
            for num in range(size):
                node = q.get()
                if node.left is None and node.right is None:
                    return depth
                
                if node.right:
                    q.put(node.right)
                    
                if node.left:
                    q.put(node.left)
            
        return depth
        
        