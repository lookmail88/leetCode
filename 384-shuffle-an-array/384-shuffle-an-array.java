class Solution {
    private int[] original;
    private int[] array;
    Random rand = new Random();
    
    
    public Solution(int[] nums) {
        original = nums;
        array = nums.clone();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
       for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
    private int randRange(int min, int max) {
      return rand.nextInt(max - min) + min;
    }
    
    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */