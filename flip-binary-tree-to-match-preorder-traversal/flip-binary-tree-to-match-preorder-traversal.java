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
    private List<Integer> flips = new ArrayList<>();
    boolean flag = false;
    private int id = 0;
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(root == null){ // exit case
            return flips;
        } else if (root.val != voyage[id]){ // parent nodes incorrect - IMPOSSIBLE
            flag = true;
        } else {
            id += 1;
            if(root.left != null && root.left.val != voyage[id] && root.right != null) { // switch child nodes if necessary
                flips.add(root.val);
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
            }
            flipMatchVoyage(root.left, voyage); // preOrder -> left
            flipMatchVoyage(root.right, voyage); // preOrder -> right
        }
        
        if(flag) { // check for flag
            List<Integer> l = new ArrayList<>();
            l.add(-1);
            return l;
        } 
        return flips;
    }
}