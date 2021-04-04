class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int c = sweetness.length;
        int left = 0;
        int right = Arrays.stream(sweetness).sum();
        System.out.println("left:"+left+",right:"+right);
        
        while(left<right){
            int mid = (left+right+1)/2;
            if(canPass(sweetness,K,mid)){
                left = mid;
            }else{
                right=mid-1;
            }
        }
        
        
        return left;
    }
    
    private boolean canPass(int[] sweetness, int K,int x){
        int c =0,count =0;
        for (int s:sweetness){
            c+=s;
            if(c >=x){
                c=0;
                count++;
                if(count>K) break;
            }
        }
        return count>K;
    }
    
    
}