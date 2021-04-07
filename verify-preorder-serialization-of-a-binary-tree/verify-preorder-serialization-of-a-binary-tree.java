class Solution {
   private int root = 0;
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        return isPre(arr) && root == arr.length;
    }
    
    private boolean isPre(String[] arr) {
        if (root >= arr.length) return false;
        if (arr[root++].equals("#")) return true;
        return isPre(arr) && isPre(arr);
    }
}