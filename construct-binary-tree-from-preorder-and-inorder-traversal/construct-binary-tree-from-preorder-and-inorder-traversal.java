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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
     int n = preorder.length;
        
        return preIn(preorder, 0, n-1, inorder, 0, n-1);
        
    }
    
    private TreeNode preIn(int[] pre, int psi, int pei, int[] in, int isi, int iei){
        if(isi > iei){
            return null;
        }
        
        int idx = isi;
        
        while(in[idx] != pre[psi]){
            idx++;
        }
        
        int colse = idx - isi;
        
        TreeNode node = new TreeNode(pre[psi]);
        
        node.left = preIn(pre, psi+1, colse+psi, in, isi, idx-1);
        node.right = preIn(pre, colse+psi+1, pei, in, idx+1, iei);
        
        return node;
    }
}