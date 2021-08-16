class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==1) return nums[0];
        
        int sum =nums[0];
        int maxSum = sum;
        for (int i=0;i<nums.length;i++){
            sum =nums[i];
            for(int j =i;j<nums.length;j++){
                if (i!=j)sum = nums[j]+sum;
                    else sum = nums[j];
                if(sum>maxSum) maxSum = sum;
            }
            
            
        }
        return maxSum;
        
    }
}