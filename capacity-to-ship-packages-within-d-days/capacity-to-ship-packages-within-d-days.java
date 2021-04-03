class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        
        while(left<right){
            int mid = (left+right)/2;
            int d = 1;
            int tmp = mid;
            for (int i =0;i<weights.length;i++){
                if(tmp>=weights[i]){
                    tmp = tmp -weights[i];
                }else{
                    ++d;
                    tmp = mid - weights[i];   
                }
            }
            
            if(d<=D){
                right=mid;
            }else{
                left=mid+1;
            }    
        }
        return left;
    }
}