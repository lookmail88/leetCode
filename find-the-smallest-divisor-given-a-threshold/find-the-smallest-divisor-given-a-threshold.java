class Solution {
    public long computeSum(int[] nums, int x) {
        long s = 0;
        for (int n : nums) {
            s += n / x + (n % x == 0 ? 0 : 1); 
        }
        return s;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        // search boundaries for the divisor
        int left = 1, right = 2;
        while (computeSum(nums, right) > threshold) {
            left = right;
            right <<= 1;
        }
        
        // binary search
        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            long num = computeSum(nums, pivot);

            if (num > threshold) {
                left = pivot + 1;    
            } else {
                right = pivot - 1;    
            }    
        }
        
        // at the end of loop, left > right,
        // computeSum(right) > threshold
        // computeSum(left) <= threshold
        // --> return left
        return left;
    }
}