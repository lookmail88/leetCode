class Solution {
    public int reverse(int x) {
      //if (x=Integer.MAX_VALUE) return 0;
      boolean isNagtive = x<0?true:false;
      String intValue  = Integer.toString(Math.abs(x));
      String revertStr =  getRevert(intValue);  
      int rv =0;
        
       System.out.println(intValue);
       System.out.println(revertStr);     
       try{
        if(!isNagtive)return Integer.parseInt(revertStr)   ;
        
        rv = Integer.parseInt(revertStr);
        rv = 0-rv;      
           
       }
       catch(Exception e){
           return 0;
       } 
        
        return rv;
    }
    
    private String getRevert(String str){
        
        char[] ch = str.toCharArray(); 
        int size = str.length();
        int switchTimes = Math.round(size/2); 
         
        for (int i = 0;i<switchTimes;i++){
            char tmp = ch[i];
            ch[i] = ch[size-1-i];
            ch[size-1-i] = tmp;
        }
        return new String(ch);
        
    }
}