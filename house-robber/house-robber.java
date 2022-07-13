class Solution {
   public int rob(int[] nums) {
    int len = nums.length;
    int prePre = 0, pre = nums[0], current = nums[0];
        
    for (int i = 1; i < len; i++) {
        current = Math.max(pre, prePre + nums[i]);
        prePre = pre;
        pre = current;
    }
    return current;
   }
}